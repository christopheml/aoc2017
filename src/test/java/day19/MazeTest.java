package day19;

import java.util.List;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MazeTest {

    private static final List<String> INPUT = asList( 
            "     |          ",
            "     |  +--+    ",
            "     A  |  C    ",
            " F---|--|-E---+ ",
            "     |  |  |  D ",
            "     +B-+  +--+ ",
            ""
    );

    @Test
    public void acceptanceTest() {
        Maze maze = new Maze(INPUT);
        String word = maze.walk();
        assertThat(word).isEqualTo("ABCDEF");
        assertThat(maze.getSteps()).isEqualTo(38);
    }

}