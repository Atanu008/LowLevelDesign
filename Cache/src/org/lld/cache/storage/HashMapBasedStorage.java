package org.lld.cache.storage;

import org.lld.cache.exceptions.NotFoundException;
import org.lld.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key , Value value) throws StorageFullException {

        //If storage contains they key then just update the cache storage and return
        if(storage.containsKey(key)){
            storage.put(key, value);
            return;
        }

        if(isStorageFull()){
            throw new StorageFullException("Cache Capacity Full");
        }
        storage.put(key, value); //Put the new Key
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if(!storage.containsKey(key)){
            throw new NotFoundException(key + "doesn't exist in cache.");
        }

        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!storage.containsKey(key)){
            throw new NotFoundException(key + "doesn't exist in cache.");
        }

        return storage.get(key);
    }

    public boolean isStorageFull(){
        return storage.size() == capacity;
    }
}
