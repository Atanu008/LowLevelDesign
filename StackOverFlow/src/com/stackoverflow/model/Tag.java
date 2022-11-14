package com.stackoverflow.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Tag {

    private String tag;

    public Tag(String tag){
        this.tag = tag;
    }
}
