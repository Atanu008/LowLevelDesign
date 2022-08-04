package org.ratelimiter;

public class TokenBucketWithRefillRate extends RateLimiter{

    private int refillRate;
    private int possibleTokens;
    private long lastRequestTime;

    public TokenBucketWithRefillRate(int refillRate, int MAX_TOKEN){
        super(MAX_TOKEN);
        this.refillRate = refillRate;
        possibleTokens = 0;
        lastRequestTime = System.currentTimeMillis();
    }
    @Override
    public synchronized boolean allowRequest() {
        refill();
        //No Token Available
        if(possibleTokens == 0){
            return false;
        }
        //Consume Token
        possibleTokens--;

        return true;
    }

    private void refill() {
        long currentTime = System.currentTimeMillis();
        // Time elapsed in sec * refillRate = no Of Token added
        possibleTokens += ((currentTime - lastRequestTime) / 1000) * refillRate;
        possibleTokens = Math.min(possibleTokens, MAX_TOKEN);

    }
}
