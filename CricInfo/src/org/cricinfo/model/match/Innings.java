package org.cricinfo.model.match;

import java.util.HashMap;
import java.util.Map;

public class Innings {
    private int inningsNumber;
    private Map<Integer, Over> overs;

    public Innings(int inningsNumber){
        this.inningsNumber = inningsNumber;
        overs = new HashMap<>();
    }

    //To-Do
    //Iterate throygh overs in one inning and sum
    public int getInningScore(){
        return 0;
    }
}
