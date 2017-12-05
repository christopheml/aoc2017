package day5;

public class Maze {

    private final int[] maze;

    private int position;

    private int steps;

    private final OffsetUpdateStrategy offsetUpdateStrategy;

    public static Maze simpleMaze(int... maze) {
        return new Maze(offset -> offset + 1, maze);
    }

    private Maze(OffsetUpdateStrategy offsetUpdateStrategy, int... maze) {
        this.maze = maze;
        this.offsetUpdateStrategy = offsetUpdateStrategy;
        position = 0;
        steps = 0;
    }

    public int run() {
        while (inMaze()) {
            int origin = position;
            jump();
            maze[origin] = offsetUpdateStrategy.update(maze[origin]);
            steps++;
        }
        return steps;
    }

    private void jump() {
        int offset = maze[position];
        position += offset;
    }

    private boolean inMaze() {
        return (position >= 0) && (position < maze.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Maze: [");
        for (int i = 0; i < maze.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            if (position == i) {
                sb.append('(').append(maze[i]).append(')');
            } else {
                sb.append(maze[i]);
            }
        }
        sb.append(']');
        if (!inMaze()) {
            sb.append(" out!");
        }
        return sb.toString();
    }

}
