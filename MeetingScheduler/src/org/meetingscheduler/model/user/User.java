package org.meetingscheduler.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
