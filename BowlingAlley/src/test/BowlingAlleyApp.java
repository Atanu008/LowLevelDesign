package test;

import bowlingalley.BowlingGame;
import bowlingalley.model.Player;
import bowlingalley.scoreboard.ScoreBoardImpl;

public class BowlingAlleyApp {

    public static void main(String[] args) {

        Player p1 = new Player("Player1", new ScoreBoardImpl());
        Player p2 = new Player("Player2", new ScoreBoardImpl());
        Player p3 = new Player("Player3", new ScoreBoardImpl());
        Player p4 = new Player("Player4", new ScoreBoardImpl());

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.addPlayer(p1);
        bowlingGame.addPlayer(p2);
        bowlingGame.addPlayer(p3);
        bowlingGame.addPlayer(p4);

        bowlingGame.startGame();

        System.out.println(bowlingGame.getWinner());

    }
}
