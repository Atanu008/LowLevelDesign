package org.ratelimiter;

public class TokenBucketNaive extends RateLimiter {

    private int possibleTokens;
    private long lastRequestTime;

    public TokenBucketNaive(int MAX_TOKEN) {
        super(MAX_TOKEN);
        this.possibleTokens = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean allowRequest(){
        refill();//Once a request arrives refill the tokens, Lazy token filling . NOt via a daemon thread

        if(possibleTokens == 0){
            return false;
        }

        possibleTokens--; // Take the token
        lastRequestTime = System.currentTimeMillis();

        return true;
    }

    private void refill(){
        long currentTime = System.currentTimeMillis();
        // Assuming one sec we have one token added
        // There ca be a RiffleRate parameter too , Rate can e multiplied
        possibleTokens += ((currentTime - lastRequestTime) / 1000);
        possibleTokens = Math.min(possibleTokens, MAX_TOKEN);
    }
}
