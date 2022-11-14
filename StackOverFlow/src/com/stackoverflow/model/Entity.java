package com.stackoverflow.model;

import com.stackoverflow.common.Status;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Entity is an abstract class
// since we will not be creating an object of this class
// without specifying if this is a question, answer or comment.

//No Setter is being used. few methods exposed to update attribute. mandatory elements passed via constructor
@Getter
public abstract class Entity {

    protected String id;

    protected String text;
    protected Long creationDateTime; //Coversion is easy in long instaed of LocalDateTime
    protected Long lastUpdatedDate;
    protected Member creator;
    protected List<Photo> photos;
    protected Set<String> membersWhoDownVotedThisEntity;
    protected Set<String> membersWhoUpVotedThisEntity;
    protected int numberOfUsersReportedThisEntity; // members reported as spam or abuse
    protected Status status;


    public Entity(@NonNull final String id, @NonNull final Member creator, @NonNull final String text, List<Photo> photos){

        this.id = id;
        this.creator = creator;
        this.text = text;

        this.photos = new ArrayList<>();
        if(photos != null){
            this.photos = photos;
        }

        long currentTime = System.currentTimeMillis();
        this.creationDateTime = currentTime;
        this.lastUpdatedDate = currentTime;
        membersWhoDownVotedThisEntity = new HashSet<>();
        membersWhoUpVotedThisEntity = new HashSet<>();
        numberOfUsersReportedThisEntity = 0;
        status = Status.DEFAULT;
    }

    public boolean equals(Object object){

        if(object instanceof Entity){
            return this.id.equals(((Entity)object).id);
        }
        return false;
    }

    //The docs are pretty clear on this: HashSet.add doesn't replace:
    //But HashMap.put will replace:
    //https://stackoverflow.com/questions/12940663/does-adding-a-duplicate-value-to-a-hashset-hashmap-replace-the-previous-value
    public void upVote(String memberId){
        // a member cannot upvote a comment that he/she has already upvoted
        if(membersWhoUpVotedThisEntity.add(memberId)){
            // if the member has downvoted this comment in past then upvoting it once just
            // cancels the downvote
            System.out.println("Member ID : "+memberId +" up voting Question ID : "+ this.getId());
            membersWhoDownVotedThisEntity.remove(memberId);
        }else{
            System.out.println("Member ID : "+memberId +" already up voted Question ID : "+ this.getId());
        }
    }

    public void downVote(String memberId){
        // a member cannot upvote a comment that he/she has already downvote
        if(membersWhoDownVotedThisEntity.add(memberId)){
            // if the member has upvoted this comment in past then downvoting it once just
            // cancels the upvote.
            System.out.println("Member ID : "+memberId +" down voting Question ID : "+ this.getId());
            membersWhoUpVotedThisEntity.remove(memberId);
        }
        else{
            System.out.println("Member ID : "+memberId +" already down voted Question ID : "+ this.getId());
        }
    }

    public void report(){
        numberOfUsersReportedThisEntity++;
    }

    public void updateText(String text){
        this.text = text;
        this.lastUpdatedDate = System.currentTimeMillis();
    }

    public void removePhotos(List<Photo> photos){
        photos.removeAll(photos);
        this.lastUpdatedDate = System.currentTimeMillis();
    }

    public void addPhotos(List<Photo> photos){
        photos.addAll(photos);
        this.lastUpdatedDate = System.currentTimeMillis();
    }

    public void delete(){
        this.status = Status.DELETED;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", creator=" + creator +
                ", photos=" + photos +
                ", membersWhoDownVotedThisEntity=" + membersWhoDownVotedThisEntity +
                ", membersWhoUpVotedThisEntity=" + membersWhoUpVotedThisEntity +
                ", numberOfUsersReportedThisEntity=" + numberOfUsersReportedThisEntity +
                ", status=" + status +
                '}';
    }
}
