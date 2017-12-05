package day5;

public class Maze {

    private int[] maze;

    private int position;

    private int steps;

    public Maze(int... maze) {
        this.maze = maze;
        position = 0;
        steps = 0;
    }

    public int run() {
        while (inMaze()) {
            System.out.println(this);
            int origin = position;
            jump();
            maze[origin]++;
            steps++;
        }
        System.out.println(this);
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
