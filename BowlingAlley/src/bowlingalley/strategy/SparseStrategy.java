package bowlingalley.strategy;

public class SparseStrategy implements Strategy{

    private static final Integer SPARSE_BONUS = 5;
    @Override
    public int bonus() {
        return SPARSE_BONUS;
    }
}
