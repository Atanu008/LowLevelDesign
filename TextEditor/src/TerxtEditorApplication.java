import org.texteditor.app.TextEditor;

public class TerxtEditorApplication {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        textEditor.insert('A'); textEditor.print();
        textEditor.insert('B');textEditor.print();
        textEditor.insert('C'); textEditor.print();
        textEditor.insert('D'); textEditor.print();

        textEditor.undo();textEditor.print();
        textEditor.undo();textEditor.print();
        textEditor.undo();textEditor.print();
        textEditor.undo();textEditor.print();

        textEditor.insert('A'); textEditor.print();
        textEditor.insert('B');textEditor.print();
        textEditor.insert('C'); textEditor.print();
        textEditor.insert('D'); textEditor.print();

        textEditor.moveLeft(); textEditor.print();
        textEditor.undo(); textEditor.print();
        textEditor.moveLeft(); textEditor.print();
        textEditor.moveLeft(); textEditor.print();

        textEditor.moveRight(); textEditor.print();
        textEditor.moveRight(); textEditor.print();
        textEditor.moveRight(); textEditor.print();

        textEditor.backspace(); textEditor.print();
        textEditor.moveLeft(); textEditor.print();

        textEditor.undo(); textEditor.print();
        textEditor.undo(); textEditor.print();
        textEditor.undo(); textEditor.print();
        textEditor.undo(); textEditor.print();

    }
}
