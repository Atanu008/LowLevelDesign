package bowlingalley.strategy;

public class DefaultStrategy implements Strategy{

    private static final int DEFAULT_BONUS = 1;
    @Override
    public int bonus() {
        return DEFAULT_BONUS;
    }
}
