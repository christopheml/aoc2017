package day11;

import java.util.List;

interface ReductionRule {

    boolean appliesTo(List<Direction> directions);

    void applyTo(List<Direction> directions);

}
