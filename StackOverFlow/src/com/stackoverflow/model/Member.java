package com.stackoverflow.model;

import com.stackoverflow.common.AccountStatus;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
public class Member {

    private String id;
    private AccountStatus accountStatus;
    private String name;
    private String displayName;
    private String email;
    private int reputation;
    private boolean isModerator;
    private boolean isAdmin;

    public Member(String name, String displayName, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.displayName = displayName;
        this.email = email;
        this.accountStatus = AccountStatus.ACTIVE;
    }

    public boolean closeQuestion(Question question){
        // only moderator, admin or creator of the question can close a question
        if(isAdmin || isModerator || this.getId().equals(question.getCreator().getId())){
            question.close();
            return true;
        }
        return false;
    }

    // a question asker can give bounty to someone who has satisfactorily answered to his/her question
    public boolean giveBounty(int bountyReputation, Member receiver){
        if(bountyReputation <= this.getReputation() && !this.getId().equals(receiver.getId())){
            this.reputation -= bountyReputation;
            receiver.receiveBounty(bountyReputation);
            return true;
        }
        return false;
    }

    // a member receives bounty if his/her answer to a question
    // satisfies the question creator and the question creator gives the answerer the bounty
    public void receiveBounty(int bountyReputation){
        this.reputation += bountyReputation;
    }

    public void closeAccount(){
        this.accountStatus = AccountStatus.CLOSED;
    }

    public void cancelAccount() {
        accountStatus = AccountStatus.CANCELLED;
    }

    public void blacklist() {
        accountStatus = AccountStatus.BLACKLISTED;
    }

    public void block() {
        accountStatus = AccountStatus.BLOCKED;
    }

    public boolean blockMember(Member member){
        if(isAdmin){
            member.block();
            return true;
        }
        return false;
    }

    public boolean unblockMember(Member member){
        if(isAdmin){
            member.accountStatus = AccountStatus.ACTIVE;
            return true;
        }
        return false;
    }

    public void promoteToAdmin(){
        isAdmin = true;
    }

    public void promoteToModerator(){
        isModerator = true;
    }

    @Override
    public String toString() {
        return "Member{" +
                "accountStatus=" + accountStatus +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", reputation=" + reputation +
                ", isModerator=" + isModerator +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
