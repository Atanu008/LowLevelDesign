package org.bms.model;

import lombok.Getter;

@Getter
public class Movie {
    String id;
    String name;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
