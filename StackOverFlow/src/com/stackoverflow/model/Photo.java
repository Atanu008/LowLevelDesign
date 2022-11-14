package com.stackoverflow.model;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
public class Photo {

    private String id;
    private String photoPath;
    private long creationDate;
    private Member creatingMember;

    public Photo(String photoPath, Member creatingMember){
        id = UUID.randomUUID().toString();
        this.photoPath = photoPath;
        this.creationDate = System.currentTimeMillis();
        this.creatingMember = creatingMember;
    }

    public boolean equals(Object object){
        if(object instanceof Photo){
            return this.id.equals(((Photo)object).id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoPath='" + photoPath + '\'' +
                ", creationDate=" + creationDate +
                ", creatingMember=" + creatingMember +
                '}';
    }
}
