package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.constants.BallType;
import org.cricinfo.model.constants.RunType;
import org.cricinfo.model.people.Player;

import java.util.List;

@Getter
@Setter
public class Ball {
    private int overNumber;
    private BallType ballType;
    private Player bowledBy;
    private Player facedBy;

    private RunType runType;
    private List<Run> runs;
    private Wicket wicket;
    private Commentry commentry;

    public Ball(int overNumber, Player bowledBy, Player facedBy){
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        this.facedBy = facedBy;
    }

}
