package org.ratelimiter.test;

public class Main {

    public static void main(String[] args) {

        long windowKey = (long) (System.currentTimeMillis() / 1e3);

        System.out.println(windowKey);
    }
}
