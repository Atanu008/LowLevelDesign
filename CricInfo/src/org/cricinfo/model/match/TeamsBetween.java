package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.people.PlayingMembers;

@Getter
@Setter
public class TeamsBetween {

    private Team team1;
    private Team team2;

    private PlayingMembers team1PlayingMembers;
    private PlayingMembers team2PlayingMembers;

    public TeamsBetween(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }
}
