package bowlingalley.model;

import bowlingalley.scoreboard.ScoreBoard;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Player {

    private String id;
    private String name;
    private final ScoreBoard scoreBoard;
    private boolean won;

    public Player(String name, ScoreBoard scoreBoard) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.scoreBoard = scoreBoard;
        this.won = false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", scoreBoard=" + scoreBoard.score() +
                ", won=" + won +
                '}';
    }
}
