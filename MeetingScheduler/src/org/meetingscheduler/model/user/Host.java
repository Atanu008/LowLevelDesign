package org.meetingscheduler.model.user;

import java.util.UUID;

public class Host extends User{
    public Host(String name, String email) {
        super(UUID.randomUUID().toString(), name, email);
    }
}
