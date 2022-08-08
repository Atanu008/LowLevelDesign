package org.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//https://www.educative.io/courses/grokking-modern-system-design-software-engineers-managers/q2zzAmqQOy3
public class SlidingWindowCounter extends RateLimiter{

    Map<Long, AtomicInteger> windows;

    public SlidingWindowCounter(int maxRequestPerSec) {
        super(maxRequestPerSec);
        windows = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest() {

        long currentTime = System.currentTimeMillis();
        long currentWindow = currentTime / 1000; //window in second;
        windows.putIfAbsent(currentWindow, new AtomicInteger(0)); // Create current window if not created
        long previousWindow = currentWindow - 1;

        AtomicInteger previousWindowCount= windows.get(previousWindow); // get previous window hit
        //No previous window
        if(previousWindowCount == null){
            return windows.get(currentWindow).getAndIncrement() <= MAX_TOKEN;
        }

        long currentWindowOverLapTime = currentTime - (currentWindow * 1000);
        double previousWindowOverLapPercentage = (1000 - currentWindowOverLapTime) / 1000.0;

        long requestCountInCurrentSlidingWindow = (long)(previousWindowCount.get() * previousWindowOverLapPercentage
                                                  + windows.get(currentWindow).getAndIncrement());

        return requestCountInCurrentSlidingWindow <= MAX_TOKEN;
    }
}
