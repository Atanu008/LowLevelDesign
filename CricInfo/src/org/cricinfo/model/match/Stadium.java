package org.cricinfo.model.match;

import lombok.Getter;
import lombok.Setter;
import org.cricinfo.model.common.Address;

@Getter
@Setter
public class Stadium {
    private String name;
    private Address address;
}
