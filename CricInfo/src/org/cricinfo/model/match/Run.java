package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.constants.RunType;

@Setter
@Getter
public class Run {
    private int scoredRun;
    private RunType runType;
}
