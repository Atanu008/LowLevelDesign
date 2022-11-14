package com.stackoverflow.model;

import com.stackoverflow.common.Status;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//No Setter is being used. few methods exposed to update attribute. mandatory elements passed via constructor
@Getter
public class Question extends Entity{

    private String title;
    private Bounty bounty;

    private List<Tag> tags;
    private List<Comment> comments;
    private List<Answer> answers;

    public Question(@NonNull final String title, @NonNull Member askingMember, @NonNull String text, List<Photo> photos, List<Tag> tags, Bounty bounty) {
        super(UUID.randomUUID().toString(), askingMember, text, photos);

        status = Status.OPEN;
        this.title = title;
        this.bounty = bounty;

        if(tags != null){
            this.tags = tags;
        }
        else{
            tags = new ArrayList<>();
        }

        comments = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public void close() { // Question Asker or Admin can close a question due to various reasons like a solution has been found or due to inactivity of users or certain other reaons
        status = Status.CLOSED;
    }

    public void addComment(Comment newComment) {
        comments.add(newComment);
    }

    public void addAnswer(Answer newAnswer) {
        answers.add(newAnswer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", creator=" + creator +
                ", membersWhoDownVotedThisEntity=" + membersWhoDownVotedThisEntity +
                ", membersWhoUpVotedThisEntity=" + membersWhoUpVotedThisEntity +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", bounty=" + bounty +
                ", tags=" + tags +
                ", comments=" + comments +
                ", answers=" + answers +
                '}';
    }
}
