package org.lld.cache.algorithms;

import org.lld.cache.exceptions.InvalidItemException;

public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList(){
        // We can instantiate these by null, since we are never gonna use val for these dummyNodes
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);
        // Also Initially there are no items
        // so just join dummyHead and Tail, we can add items in between them easily.
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element){
        if(element == null){
            throw new InvalidItemException();
        }

        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> newNode) {
        //Get Last Element i,e prev elemenet of dummyTail
        DoublyLinkedListNode tailPrev = dummyTail.prev;
        //Fix Left Side new Node
        tailPrev.next = newNode;
        newNode.prev = tailPrev;
        //Fixe right side of the new Node
        newNode.next = dummyTail;
        dummyTail.prev = newNode;
    }

    /**
     * Method to detach a random node from the doubly linked list. The node itself will not be removed from the memory.
     * Just that it will be removed from the list and becomes orphaned and will be garbage collected
     *
     * @param node Node to be detached.
     */
    public void detachNode(DoublyLinkedListNode<E> node){
        if(node != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public boolean isCacheEmpty(){
        return dummyHead.next == dummyTail;
    }

    public DoublyLinkedListNode getFirstNode(){

        if(!isCacheEmpty()){
            return dummyHead.next;
        }
        return null;
    }

    public DoublyLinkedListNode getLastNode(){

        if(!isCacheEmpty()){
            return dummyTail.next;
        }
        return null;
    }
}
