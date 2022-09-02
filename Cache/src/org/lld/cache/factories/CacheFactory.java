package org.lld.cache.factories;

import org.lld.cache.Cache;
import org.lld.cache.policies.LRUEvictionPolicy;
import org.lld.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity){
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
    }

}
