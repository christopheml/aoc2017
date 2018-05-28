package day19;

import java.util.List;

import static java.lang.Character.isLetter;

public class Maze {

    private static final char VERTICAL = '|';

    private static final char TURN = '+';

    public int getSteps() {
        return steps;
    }

    private enum Direction { UP, DOWN, LEFT, RIGHT }

    private int steps;

    private static class Position {
        private final int x;
        private final int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position apply(Direction direction) {
            switch (direction) {
                case UP:
                    return new Position(x - 1, y);
                case DOWN:
                    return new Position(x + 1, y);
                case LEFT:
                    return new Position(x, y - 1);
                case RIGHT:
                    return new Position(x, y + 1);
            }
            throw new IllegalStateException();
        }

    }

    private final List<String> input;

    public Maze(List<String> input) {
        this.input = input;
    }

    String walk() {
        String result = "";

        // Starting at the top
        Position position = new Position(0,  detectEntrance());
        Direction direction = Direction.DOWN;

        char current;

        do {
            steps++;
            position = position.apply(direction);

            current = read(position);

            if (isLetter(current)) {
                result += current;
            } else if (current == TURN){
                direction = turn(direction, position);
            }
        } while (isNotBlank(current));

        return result;
    }

    private Direction turn(Direction direction, Position position) {
        if (direction != Direction.UP) {
            Position candidate = position.apply(Direction.DOWN);
            if (isNotBlank(read(candidate))) {
                return Direction.DOWN;
            }
        }
        if (direction != Direction.DOWN) {
            Position candidate = position.apply(Direction.UP);
            if (isNotBlank(read(candidate))) {
                return Direction.UP;
            }
        }
        if (direction != Direction.LEFT) {
            Position candidate = position.apply(Direction.RIGHT);
            if (isNotBlank(read(candidate))) {
                return Direction.RIGHT;
            }
        }
        if (direction != Direction.RIGHT) {
            Position candidate = position.apply(Direction.LEFT);
            if (isNotBlank(read(candidate))) {
                return Direction.LEFT;
            }
        }
        throw new IllegalStateException("Nowhere to turn");
    }

    private boolean isNotBlank(char current) {
        return !Character.isSpaceChar(current);
    }

    private char read(Position position) {
        String line = input.get(position.x);
        if (position.y > line.length() - 1) {
            // Artificial space padding the end of lines
            return ' ';
        }
        return line.charAt(position.y);
    }

    private int detectEntrance() {
        return input.get(0).indexOf(VERTICAL);
    }

}
