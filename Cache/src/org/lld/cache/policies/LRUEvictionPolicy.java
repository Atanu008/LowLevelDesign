package org.lld.cache.policies;

import org.lld.cache.algorithms.DoublyLinkedList;
import org.lld.cache.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    DoublyLinkedList<Key> dll;
    Map<Key, DoublyLinkedListNode<Key>> map;

    public LRUEvictionPolicy(){
        dll = new DoublyLinkedList<>();
        map = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {

        if(map.containsKey(key)){
            dll.detachNode(map.get(key));
            dll.addNodeAtLast(map.get(key));
        }
        else{
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            map.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {

        DoublyLinkedListNode<Key> firstNode = dll.getFirstNode();
        if(firstNode == null){
            return null;
        }

        dll.detachNode(firstNode);
        map.remove(firstNode.getElement());

        return firstNode.getElement();

    }

}
