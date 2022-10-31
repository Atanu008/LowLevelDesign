package org.cricinfo.model.match;

import org.cricinfo.model.constants.MatchResult;
import org.cricinfo.model.people.Commentator;
import org.cricinfo.model.people.Referee;
import org.cricinfo.model.people.Scorer;
import org.cricinfo.model.people.Umpire;

import java.time.LocalDateTime;
import java.util.*;

public abstract class Match {

    private String matchId;
    private Tournament tournament;
    private final TeamsBetween teamsBetween;
    private String venue;
    private Toss toss;
    private LocalDateTime startTime;
    private LocalDateTime endTtime;
    private Team winner;
    private Team lost;
    private MatchResult matchResult;
    private Map<Team, Map<Integer, Innings>> innings;

    private List<Umpire> umpires;
    private List<Commentator> commentators;
    private List<Referee> referees;
    private List<Scorer> scorers;


    public Match(TeamsBetween teamsBetween) {
        matchId = UUID.randomUUID().toString();
        this.teamsBetween = teamsBetween;
        umpires = new ArrayList<>();
        innings = new HashMap<>();
        commentators = new ArrayList<>();
        scorers = new ArrayList<>();
        referees = new ArrayList<>();
    }
}
