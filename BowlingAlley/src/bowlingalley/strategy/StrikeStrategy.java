package bowlingalley.strategy;

public class StrikeStrategy implements Strategy{

    private static final Integer STRIKE_BONUS = 5;
    @Override
    public int bonus() {
        return STRIKE_BONUS;
    }
}
