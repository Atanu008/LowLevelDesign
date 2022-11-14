package com.stackoverflow.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter

public class Comment extends Entity{
    public Comment(@NonNull Member creator, @NonNull String text, List<Photo> photos) {
        super(UUID.randomUUID().toString(), creator, text, photos);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", creator=" + creator +
                ", photos=" + photos +
                '}';
    }
}
