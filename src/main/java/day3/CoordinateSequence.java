package day3;

import java.util.List;
import java.util.function.UnaryOperator;

import static java.util.Arrays.asList;

public class CoordinateSequence {

    private int step = 1;

    private int directionChanges = 0;

    private int stepsLeftUntilChange;

    private Coordinate position;

    private UnaryOperator<Coordinate> direction;

    private static final List<UnaryOperator<Coordinate>> directions = asList(Coordinate::right, Coordinate::up, Coordinate::left, Coordinate::down);

    CoordinateSequence() {
        position = Coordinate.origin();
        stepsLeftUntilChange = 1;
        direction = nextDirection();
    }

    Coordinate nextStep() {
        if (stepsLeftUntilChange > 0) {
            stepsLeftUntilChange--;
        } else {
            changeDirection();
        }
        doNextStep();
        return position;
    }

    int getStep() {
        return step;
    }

    Coordinate getPosition() {
        return position;
    }

    private void changeDirection() {
        directionChanges++;
        stepsLeftUntilChange = nextStepCount();
        direction = nextDirection();
    }

    private void doNextStep() {
        step++;
        position = direction.apply(position);
    }

    private int nextStepCount() {
        // The expected sequence is 0, 0, 1, 1, 2, 2, 3, 3...
        return ((directionChanges + 2) / 2) - 1;
    }

    private UnaryOperator<Coordinate> nextDirection() {
        return directions.get(directionChanges % 4);
    }

    @Override
    public String toString() {
        return "CoordinateSequence{" +
                "step=" + step +
                ", directionChanges=" + directionChanges +
                ", stepsLeftUntilChange=" + stepsLeftUntilChange +
                ", position=" + position +
                '}';
    }

}
