package bowlingalley.scoreboard;

import bowlingalley.constants.AppConstants;
import bowlingalley.factory.BonusFactory;
import bowlingalley.model.Bonus;

public class ScoreBoardImpl extends ScoreBoard{

    private final int[] rolls;
    private Integer currentRoll = 0;
    public ScoreBoardImpl() {
        this.rolls = new int[AppConstants.MAX_ROLLS];
    }

    @Override
    public void roll(Integer numPinDown) {

        if(currentRoll== AppConstants.MAX_ROLLS-1)
            rolls[currentRoll] = numPinDown;
        else
            rolls[currentRoll++] = numPinDown;
    }

    @Override
    public Integer score() {
        int totalScore = 0;
        int set = 0;

        for (int i = 0; i < AppConstants.TOTAL_SETS; i++) {
            if (isStrike(set)) {
                totalScore  += AppConstants.TOTAL_PINS + BonusFactory.getStrategy(Bonus.STRIKE).bonus();
            } else if (isSpare(set)) {
                totalScore  += AppConstants.TOTAL_PINS + BonusFactory.getStrategy(Bonus.SPARE).bonus();
            } else {
                totalScore  += rolls[set] + rolls[set + 1];
            }
            set += 2;
        }
        return totalScore + rolls[set];
    }

    private boolean isSpare(int set) {
        return rolls[set]  +  rolls[set + 1] == 10;
    }

    private boolean isStrike(int set) {
        return rolls[set] == 10;
    }

    public boolean isEligibleForLastBonus(){
        return rolls[currentRoll - 1] + rolls[currentRoll - 2] == AppConstants.TOTAL_PINS;
    }

    public boolean isLastRound(){
        return currentRoll == AppConstants.MAX_ROLLS - 1;
    }
}
