package day11;


import java.util.List;

public class RemoveRule implements ReductionRule {

    private final Direction d1;
    private final Direction d2;

    RemoveRule(Direction d1, Direction d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public boolean appliesTo(List<Direction> directions) {
        return directions.contains(d1) && directions.contains(d2);
    }

    @Override
    public void applyTo(List<Direction> directions) {
        directions.remove(d1);
        directions.remove(d2);
    }

}
