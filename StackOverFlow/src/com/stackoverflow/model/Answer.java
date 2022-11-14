package com.stackoverflow.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Getter
public class Answer extends Entity{

    private boolean solvedProblem;
    private List<Comment> comments;

    public Answer(@NonNull Member creatingMember, @NonNull String text, List<Photo> photos) {
        super(UUID.randomUUID().toString(), creatingMember, text, photos);
    }

    public void markAsASolution(){
        solvedProblem = true;
    }

    public void addComment(Comment newComment){
        comments.add(newComment);
    }

    public void updateText(String newText){
        this.text = newText;
        this.lastUpdatedDate = System.currentTimeMillis();
    }

    public void receiveBounty(int reputation){
        creator.receiveBounty(reputation);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "solvedProblem=" + solvedProblem +
                ", comments=" + comments +
                ", text='" + text + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", creator=" + creator +
                ", photos=" + photos +
                ", status=" + status +
                '}';
    }
}
