package day5;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MazeTest {

    @Test
    public void main_example() throws Exception {
        Maze maze = Maze.simpleMaze(0, 3, 0, 1, -3);
        int steps = maze.run();
        assertThat(steps).isEqualTo(5);
    }

    @Test
    public void alernative_example() throws Exception {
        Maze maze = Maze.advancedMaze(0, 3, 0, 1, -3);
        int steps = maze.run();
        assertThat(steps).isEqualTo(10);
    }

}
