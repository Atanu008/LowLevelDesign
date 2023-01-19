package org.texteditor.app;

import org.texteditor.model.Action;
import org.texteditor.model.CharacterNode;
import org.texteditor.model.ITextEditor;
import org.texteditor.model.Revision;

import java.util.Stack;

public class TextEditor implements ITextEditor {

    CharacterNode start, cursor;
    Stack<Revision> undoStack;
    int numChar;

    public TextEditor(){
        cursor = new CharacterNode('\0'); // '\0' is END Of String
        start = null;
        undoStack = new Stack<>();
        numChar = 0;
    }

    /*
         e.g. - ajggaf\0g
          suppose cursor is at above position.
          After moving left  - ajgga\0fg
     */
    @Override
    public void moveLeft() {
        if(cursor.getPrev() == null){
            return;
        }
        cursor = cursor.getPrev();
        // Move cursor to RIGHT in case of undo
        undoStack.push(new Revision(Action.RIGHT, null));
    }

    @Override
    public void moveRight() {
        if(cursor.getNext() == null){
            return;
        }
        cursor = cursor.getNext();
        // Move cursor to LEFT in case of undo
        undoStack.push(new Revision(Action.LEFT, null));
    }

    @Override
    public void backspace() {
        // no char to delete
        if(cursor.getPrev() == null){
            return;
        }

        CharacterNode chDeleted = delete(cursor.getPrev());
        undoStack.push(new Revision(Action.INSERT, chDeleted));
    }

    private CharacterNode delete(CharacterNode toDelete) {
        //Decrement numChar as we are deleting tone characer
        numChar--;

        CharacterNode prev = toDelete.getPrev();
        CharacterNode next = toDelete.getNext();

        if(prev != null){
            prev.setNext(next);
        }

        if(next != null){
            next.setPrev(prev);
        }

        //Only One character was there and we are removing it
        if(toDelete.getPrev() == null && numChar == 0){
            start = null;
        }
        //We are deleteing the first element but we still have remaining element at right
        if(toDelete == start){
            start = next;
        }
        /*
        As we have initialised cursor with end_of_string '\0'
        So, if all characters are removed already and again some1 tries to do backspace.
         */
        if (cursor.getPrev() == null && numChar == 0) {
            start = null;
        }

        return toDelete;
    }


    @Override
    public void insert(char data){
        insert(data, true);
    }

    private void insert(char data, boolean recordInStack) {

        CharacterNode newNode = new CharacterNode(data);
        CharacterNode prev = cursor.getPrev();

        newNode.setNext(cursor);
        cursor.setPrev(newNode);

        if(prev != null){
            newNode.setPrev(prev);
            prev.setNext(newNode);
        }else {
            start = newNode;
        }

        numChar++;
        if(recordInStack){
            undoStack.push(new Revision(Action.DELETE, newNode));
        }
    }

    @Override
    //This is Imp
    //While doing undo , dont push that action is stack, otherwise it will be toggling between undoing and redoing
    public void undo() {

        if(undoStack.isEmpty()){
            return;
        }

        Revision revision = undoStack.pop();
        Action undoAction = revision.getAction();

        switch (undoAction){

            case LEFT:
                if(cursor != null && cursor.getPrev() != null){
                    cursor = cursor.getPrev();
                }
                break;

            case RIGHT:
                if(cursor != null && cursor.getNext() != null){
                    cursor = cursor.getNext();
                }
                break;

            case INSERT:
                insert(revision.getCharacterNode().getCh(), false);
                break;

            case DELETE:
                if (cursor != null){
                    // if we have added only one character and we want to do undo.
                    // In that case, that one character will be removed making the whole
                    // text empty. Hence start becomes null.
                    if(cursor.getPrev() == null){
                        start = null;
                    }
                    delete(cursor.getPrev());// We always inserft at prev/left position of cursor, so do the same for delete
                }
                break;

            default:
                return;
        }
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        CharacterNode temp = start;

        //When there is no character just print the cursor
        if(start == null){
            sb.append("|");
        }

        while(temp != null){

            if(temp == cursor){
                sb.append("|");//Place cursor Character
            }
            if(temp.getCh() != '\0'){
                sb.append(temp.getCh());
            }
            temp = temp.getNext();
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public CharacterNode getCursor() {
        return cursor;
    }
}
