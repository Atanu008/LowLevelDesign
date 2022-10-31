package org.cricinfo.model.people;

import org.cricinfo.model.match.Match;
import org.cricinfo.model.match.Team;
import org.cricinfo.model.match.Tournament;

public class Admin extends Person{
    public Admin(String name) {
        super(name);
    }

    public boolean addMatch(Match match) {
        return false;
    }

    public boolean addTeam(Team team) {
        return false;
    }

    public boolean addTournament(Tournament tournament) {
        return false;
    }
}
