package test;

import org.ratelimiter.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//https://hechao.li/2018/06/25/Rate-Limiter-Part1/

//CountDown Latch : https://www.baeldung.com/java-countdown-latch
//Simply put, a CountDownLatch has a counter field, which you can decrement as we require.
//We can then use it to block a calling thread until it's been counted down to zero.

//If we were doing some parallel processing,
//we could instantiate the CountDownLatch with the same value for the counter as a number of threads
//we want to work across. Then, we could just call countdown() after each thread finishes,
//guaranteeing that a dependent thread calling await() will block until the worker threads are finished.
public class RateLimiterApplication {

    public static void main(String[] args) throws InterruptedException {

         final int maxRequestPerSecond = 10;
         //RateLimiter rateLimiter = new TokenBucketNaive(maxRequestPerSecond);
         //RateLimiter rateLimiter = new TokenBucketWithRefillRate(maxRequestPerSecond, 4);
        //RateLimiter rateLimiter = TokenBucketFactory.makeTokenBucketWithDaemonThread(maxRequestPerSecond, 4);
        //RateLimiter rateLimiter = new FixedWindowCounter(maxRequestPerSecond);
        //RateLimiter rateLimiter = new SlidingWindowLog(maxRequestPerSecond);
        RateLimiter rateLimiter = new SlidingWindowCounter(maxRequestPerSecond);

         Thread thread = new Thread(() -> {
             sendRequest(rateLimiter, 10, 1);
             sendRequest(rateLimiter, 20, 2);
             sendRequest(rateLimiter,50, 5);
             sendRequest(rateLimiter,100, 10);
             sendRequest(rateLimiter,200, 20);
             sendRequest(rateLimiter,250, 25);
             sendRequest(rateLimiter,500, 50);
             sendRequest(rateLimiter,1000, 100);
         });

         thread.start();
         thread.join();


    }

    private static void sendRequest(RateLimiter rateLimiter, int totalWorkerThreadCount, int reqPerSec) {

        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(totalWorkerThreadCount);

        for(int i = 0; i < totalWorkerThreadCount; i++){
            Thread thread = new Thread(() -> {
                while(!rateLimiter.allowRequest()){
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            });
            //Start the worker Thread
            thread.start();
            try {
                //This is very Imp
                //Suppose reqPerSec = 1 , then after starting one thread we need wait for 1 sec(1000 milsec) to start a new thread
                //Suppose reqPerSec = 2 , then after starting one thread we need wait for 1/2(500 milsec) sec to start a new thread
                //Suppose reqPerSec = 3 , then after starting one thread we need wait for 1/3(333.33 milsec) sec to start a new thread
                TimeUnit.MILLISECONDS.sleep(1000 / reqPerSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double duration = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalWorkerThreadCount + " requests processed in " + duration + " seconds. "
                + "Rate: " + (double) totalWorkerThreadCount / duration + " per second");
    }
}
