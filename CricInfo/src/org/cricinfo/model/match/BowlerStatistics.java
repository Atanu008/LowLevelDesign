package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.constants.BallType;
import org.cricinfo.model.people.Player;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class BowlerStatistics {

    private Player bowler;
    private Map<Integer, Over> overMap;
    private Map<BallType, Integer> extrasBowled;
    private int wicketsTaken;

    public BowlerStatistics(Player bowler){
        this.bowler = bowler;
        overMap = new HashMap<>();
        extrasBowled = new HashMap<>();
    }

}
