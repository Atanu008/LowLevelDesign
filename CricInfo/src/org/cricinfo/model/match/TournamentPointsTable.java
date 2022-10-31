package org.cricinfo.model.match;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TournamentPointsTable {
    Map<Team, Double> teamPoints;
    LocalDateTime updateDate;

    public TournamentPointsTable(){
        this.teamPoints = new HashMap<>();
    }
}
