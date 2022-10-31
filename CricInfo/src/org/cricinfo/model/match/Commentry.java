package org.cricinfo.model.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.people.Commentator;

@Getter
@Setter
@AllArgsConstructor
public class Commentry {
    private Commentator commentator;
    private String comment;
}
