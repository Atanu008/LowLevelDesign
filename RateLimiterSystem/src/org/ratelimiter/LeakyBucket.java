package org.ratelimiter;

import java.net.http.HttpRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class LeakyBucket {

    BlockingQueue<HttpRequest> queue;

    public LeakyBucket(int capacity){
        queue = new LinkedBlockingDeque<>(capacity);
    }

    public boolean allowRequest(HttpRequest request){

        if(queue.remainingCapacity() > 0){
            queue.add(request);
            return true;
        }

        return false;
    }

}
