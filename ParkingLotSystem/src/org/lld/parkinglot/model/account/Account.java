package org.lld.parkinglot.model.account;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Account {
    private String id;
    private String email;
    private String userName;
    private String password;
    private LocalDateTime lastAccessed;
}
