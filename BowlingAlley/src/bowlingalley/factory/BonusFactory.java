package bowlingalley.factory;

import bowlingalley.model.Bonus;
import bowlingalley.strategy.DefaultStrategy;
import bowlingalley.strategy.SparseStrategy;
import bowlingalley.strategy.Strategy;
import bowlingalley.strategy.StrikeStrategy;

public class BonusFactory {

    public static Strategy getStrategy(Bonus bonus){

        return switch (bonus) {
            case SPARE -> new SparseStrategy();
            case STRIKE -> new StrikeStrategy();
            default -> new DefaultStrategy();
        };
    }
}
