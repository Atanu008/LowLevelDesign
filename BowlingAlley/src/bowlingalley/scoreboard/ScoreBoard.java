package bowlingalley.scoreboard;

public abstract class ScoreBoard {

    public abstract void roll(Integer numPinDown);
    public abstract Integer score();
    public abstract boolean isEligibleForLastBonus();
    public abstract boolean isLastRound();
}
