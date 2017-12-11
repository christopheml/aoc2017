package day11;

import java.util.List;

public class MergeRule implements ReductionRule {

    private final Direction d1;
    private final Direction d2;
    private final Direction merged;

    MergeRule(Direction d1, Direction d2, Direction merged) {
        this.d1 = d1;
        this.d2 = d2;
        this.merged = merged;
    }

    @Override
    public boolean appliesTo(List<Direction> directions) {
        return directions.contains(d1) && directions.contains(d2);
    }

    @Override
    public void applyTo(List<Direction> directions) {
        directions.remove(d1);
        directions.remove(d2);
        directions.add(merged);
    }

}
