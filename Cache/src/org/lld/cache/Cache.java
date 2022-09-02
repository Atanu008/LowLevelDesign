package org.lld.cache;

import org.lld.cache.exceptions.NotFoundException;
import org.lld.cache.exceptions.StorageFullException;
import org.lld.cache.policies.EvictionPolicy;
import org.lld.cache.storage.Storage;

public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) throws NotFoundException {

        try{
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        }catch(StorageFullException exception){

            System.out.println("Got storage full. Will try to evict.");
            Key keyToBeEvicted = this.evictionPolicy.evictKey();
            if(key == null){
                throw new RuntimeException("Unexpected State. Try Later please");
            }

            this.storage.remove(keyToBeEvicted);
            System.out.println("Creating space by evicting item..." + keyToBeEvicted);

            put(key, value);
        }
    }

    public Value get(Key key){

        try{
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        }catch(NotFoundException exception){
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
