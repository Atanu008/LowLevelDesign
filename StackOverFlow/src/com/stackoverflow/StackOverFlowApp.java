package com.stackoverflow;

import com.stackoverflow.model.*;

import java.util.ArrayList;
import java.util.List;

public class StackOverFlowApp {

    public static void main(String[] args) {

        Member admin = new Member("Admin","Admin","admin@gmail.com");
        admin.promoteToAdmin();

        Member moderator = new Member("Moderator","Moderator","moderator@gmail.com");
        moderator.promoteToModerator();

        Member questionAsker = new Member("QuestionAsker","QuestionAsker","questionAsker@gmail.com");
        Member respondentA = new Member("RespondentA","RespondentA","Respondenta@gmail.com");
        Member respondentB = new Member("RespondentA","RespondentA","Respondentb@gmail.com");

        Member commenter = new Member("Commenter","Commenter","commenter@gmail.com");

        List<Photo> photos = List.of(new Photo("/root/path1", questionAsker), new Photo("/root/path2", questionAsker));
        List<Tag> tags = List.of(new Tag("Science"), new Tag("Technology"));
        Bounty bounty = new Bounty(5000, System.currentTimeMillis() + 50000000);
        Comment comment = new Comment(commenter, "Its not blue stupid, its RED", null);

        Question question = new Question("Question A", questionAsker, "Why Sky is Blue", photos, tags, bounty);
        question.addComment(comment);

        System.out.println(question);

        Member upVoter1 = new Member("upVoter1","upVoter1","upVoter1@gmail.com");
        Member upVoter2 = new Member("upVoter2","upVoter2","upVoter2@gmail.com");

        Member downVoter1 = new Member("downVoter1","downVoter1","downVoter1@gmail.com");
        Member downVoter2 = new Member("downVoter2","downVoter2","downVoter2@gmail.com");

        question.upVote(upVoter1.getId());
        question.upVote(upVoter2.getId());

        System.out.println("Members who upvoted : "+ question.getId() +" are as below : ");
        System.out.println(question.getMembersWhoUpVotedThisEntity());

        question.upVote(upVoter1.getId());
        System.out.println("Members who upvoted : "+ question.getId() +" are as below : ");
        System.out.println(question.getMembersWhoUpVotedThisEntity());

        question.downVote(downVoter1.getId());
        question.downVote(upVoter2.getId());
        System.out.println("Members who downvoted : "+ question.getId() +" are as below : ");
        System.out.println(question.getMembersWhoDownVotedThisEntity());

        //Report Question. can handle similar way as up/down vote
        question.report();
        question.report();

        System.out.println("Number of people reported "+ question.getNumberOfUsersReportedThisEntity());

        Answer answer1 = new Answer(respondentA, "I have painted with blue color :)", null);
        Answer answer2 = new Answer(respondentB, "have a spec , its not blue", null);
        answer1.markAsASolution(); // Mark as solution

        question.addAnswer(answer1);
        question.addAnswer(answer2);

        //
        System.out.println("Answers "+question.getAnswers());
        System.out.println(question);

        //Reputation Before
        System.out.println("Reputation of Question Asker Before giving Bounty "+ questionAsker.getReputation());
        System.out.println("Reputation of Question Respondent Before giving Bounty "+ respondentA.getReputation());
        //Initialize Bounty for Question Asker
        questionAsker.receiveBounty(20000000);
        questionAsker.giveBounty(question.getBounty().getReputation(), respondentA); // Give full Bounty

        System.out.println("Reputation of Question Asker After giving Bounty "+ questionAsker.getReputation());
        System.out.println("Reputation of Question Respondent After giving Bounty "+ respondentA.getReputation());

    }
}
