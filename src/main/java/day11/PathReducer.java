package day11;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

class PathReducer {

    private final List<ReductionRule> rules;

    PathReducer() {
        rules = asList(
                new RemoveRule(Direction.N, Direction.S),
                new RemoveRule(Direction.NE, Direction.SW),
                new RemoveRule(Direction.NW, Direction.SE),
                new MergeRule(Direction.NE, Direction.NW, Direction.N),
                new MergeRule(Direction.SE, Direction.SW, Direction.S),
                new MergeRule(Direction.NE, Direction.S, Direction.SE),
                new MergeRule(Direction.NW, Direction.S, Direction.SW),
                new MergeRule(Direction.SE, Direction.N, Direction.NE),
                new MergeRule(Direction.SW, Direction.N, Direction.NW)
        );
    }

    List<Direction> reduce(List<Direction> input) {
        List<Direction> reduced = new LinkedList<>(input);

        rules.forEach(rule -> applyRule(rule, reduced));

        return reduced;
    }

    private void applyRule(ReductionRule reductionRule, List<Direction> input) {
        while (reductionRule.appliesTo(input)) {
            reductionRule.applyTo(input);
        }
    }

}
