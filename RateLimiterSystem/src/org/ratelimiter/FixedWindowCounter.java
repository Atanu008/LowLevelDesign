package org.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//https://hechao.li/2018/06/25/Rate-Limiter-Part1/
//Fixed window counter algorithm divides the timeline into fixed-size windows and assign a counter to each window. Each request, based on its arriving time, is mapped to a window. If the counter in the window has reached the limit, requests falling in this window should be rejected. For example, if we set the window size to 1 minute.
//Then the windows are [00:00, 00:01), [00:01, 00:02), ...[23:59, 00:00). Suppose the limit is 2 requests per minute:
public class FixedWindowCounter extends RateLimiter{

    // TODO: Clean up stale entries
    private final Map<Long, AtomicInteger> windows;

    public FixedWindowCounter(int maxRequestPerSec){
        super(maxRequestPerSec);
        windows = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest() {
        long windowKey = System.currentTimeMillis() / 1000 ; //Second
        windows.putIfAbsent(windowKey, new AtomicInteger(0));
        return windows.get(windowKey).getAndIncrement() <= MAX_TOKEN;
    }
}
