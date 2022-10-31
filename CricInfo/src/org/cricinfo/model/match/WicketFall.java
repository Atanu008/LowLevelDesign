package org.cricinfo.model.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.people.Player;

@AllArgsConstructor
@Setter
@Getter
public class WicketFall {
    private int wicketFallNo;
    private Player player;
    private int scoredRuns;
}
