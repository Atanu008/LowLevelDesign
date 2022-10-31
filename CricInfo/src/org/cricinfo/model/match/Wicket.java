package org.cricinfo.model.match;

import org.cricinfo.model.constants.WicketType;
import org.cricinfo.model.people.Player;

public class Wicket {
    private WicketType wicketType;
    private Player playerOut;
    private Player bowledBy;
    private Player caughtBy;
    private Player stumpedBy;
    private Player runOutBy;

    public Wicket(WicketType wicketType, Player playerOut,
                  Player bowledBy) {
        this.wicketType = wicketType;
        this.playerOut = playerOut;
        this.bowledBy = bowledBy;
    }
}
