package org.cricinfo.model.match;

import org.cricinfo.model.constants.RunType;

import java.util.ArrayList;
import java.util.List;

public class Over {

    private int overNumber;
    private int runsScored;
    private int extras;
    private int totalRunsScored;

    private List<Ball> balls;
    private List<Run> runs;

    public Over(int overNumber){
        this.overNumber = overNumber;
        balls = new ArrayList<>();
        runs = new ArrayList<>();
    }

    public boolean isMaidenOver(){
        //If any extra ball(NO_BALL or WIDE) return false
        if(balls.size() > 6){
            return false;
        }
        for(Ball ball : balls){
            if(ball.getRunType() != RunType.ZERO){
                return false;
            }
        }

        return true;
    }

    public int getWicketsInOver() {
        int wkCount = 0;
        for (Ball ball : balls) {
            if (ball.getWicket() != null) {
                wkCount += 1;
            }
        }
        return wkCount;
    }
}
