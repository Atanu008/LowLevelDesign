package org.ratelimiter;

public class TokenBucketFactory{

    private TokenBucketFactory(){
        // Force users to interact with the factory
        // only through the static methods
    }

    public static TokenBucketWithDaemonThread makeTokenBucketWithDaemonThread(int refillRate, int MAX_TOKEN){
        TokenBucketWithDaemonThread tokenBucketWithDaemonThread = new TokenBucketWithDaemonThread(refillRate, MAX_TOKEN);
        tokenBucketWithDaemonThread.initialize();
        return tokenBucketWithDaemonThread;
    }
    private static class TokenBucketWithDaemonThread extends RateLimiter{

        private int refillRate;
        private int possibleTokens;
        private final int ONE_SECOND = 1000;
        TokenBucketWithDaemonThread(int refillRate, int MAX_TOKEN){
            super(MAX_TOKEN);
            this.refillRate = refillRate;
            possibleTokens = 0;
        }

        void initialize(){
            Thread daemon = new Thread( () -> {
               refill();
            }
            );
            daemon.setDaemon(true);
            daemon.start();
        }

        private void refill() {
            //Always try to refill
            while(true){
                synchronized (this){
                    possibleTokens = Math.min(possibleTokens+refillRate, MAX_TOKEN); // Add token per refill Rate
                    this.notifyAll(); // Once refill notify consumers to consume Token
                }
                try{
                    Thread.sleep(ONE_SECOND); // sleep for one second, then wake up and add token
                } catch(InterruptedException e){

                }
            }
        }

        @Override
       public boolean allowRequest() {
             synchronized (this){
                 if(possibleTokens == 0){
                     return false;
                 }
                 possibleTokens--;
                 return true;
             }
        }

        //This Get Token is the similar implementation of allowRequest
        //Here Consumer will wait if there is no token , and will be notified by Daemon Thread after adding token
        //So No immediate return in case of zero token
        public void getToken() throws InterruptedException {

            synchronized (this) {
                while (possibleTokens == 0) {
                    this.wait();
                }
                possibleTokens--;
            }

            System.out.println(
                    "Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1000);
        }
    }
}

