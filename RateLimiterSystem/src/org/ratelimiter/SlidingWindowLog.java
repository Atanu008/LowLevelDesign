package org.ratelimiter;

import org.ratelimiter.RateLimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog extends RateLimiter {

    final Queue<Long> log;

    public SlidingWindowLog(int MAX_TOKEN) {
        super(MAX_TOKEN);
        log = new LinkedList<>();
    }

    @Override
    public boolean allowRequest() {

        long currentTime = System.currentTimeMillis(); // can be second tooo
        long windowBoundary = currentTime - 1000; // One sec window
        synchronized (log) {
            while (!log.isEmpty() && log.peek() <= windowBoundary) {
                log.poll();
            }
            log.offer(currentTime);
            return log.size() <= MAX_TOKEN;
        }
    }
}
