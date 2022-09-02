package org.lld.cache.algorithms;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {

    E element;
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
