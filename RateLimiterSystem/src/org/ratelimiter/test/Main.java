package org.ratelimiter.test;

public class Main {

    public static void main(String[] args) {

        long windowKey = (long) (System.currentTimeMillis() / 1e3);

        //System.out.println(windowKey);

        long curTime = System.currentTimeMillis();
        long curWindowKey = curTime / 1000;

        System.out.println(curTime +" "+ curWindowKey);

        long overLapTime = curTime - (curWindowKey * 1000);
        System.out.println(overLapTime);

        double percentage = (1000 - overLapTime) / 1000.0;
        System.out.println(percentage);

        //88 * 0.134 + 12;

        //1658119077506




    }
}
