package org.ratelimiter;

public abstract class RateLimiter {

    public final int MAX_TOKEN;

    public RateLimiter(int MAX_TOKEN) {
        this.MAX_TOKEN = MAX_TOKEN;
    }

    public abstract boolean allowRequest();
}
