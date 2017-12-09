package day9;

import common.Node;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreCalculatorTest {

    private static final ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    public void simple_node() {
        StreamParser parser = new StreamParser();
        Node<Integer> node = parser.parse(asList(Token.GROUP_OPEN, Token.GARBAGE_OPEN, Token.GARBAGE, Token.GARBAGE_CLOSE, Token.REGULAR, Token.GROUP_CLOSE));

        assertThat(scoreCalculator.assignScores(node)).isEqualTo(1);
    }

    @Test
    public void node_with_one_child() {
        StreamParser parser = new StreamParser();
        Node<Integer> root = parser.parse(asList(Token.GROUP_OPEN, Token.GROUP_OPEN, Token.GROUP_CLOSE, Token.GROUP_CLOSE));

        assertThat(scoreCalculator.assignScores(root)).isEqualTo(3);
    }

    @Test
    public void node_with_two_child() {
        StreamParser parser = new StreamParser();
        Node<Integer> root = parser.parse(asList(Token.GROUP_OPEN, Token.GROUP_OPEN, Token.GROUP_CLOSE, Token.GROUP_OPEN, Token.GROUP_CLOSE, Token.GROUP_CLOSE));

        assertThat(scoreCalculator.assignScores(root)).isEqualTo(5);
    }

    @Test
    public void node_with_two_levels_of_children() {
        StreamParser parser = new StreamParser();
        Node<Integer> root = parser.parse(asList(Token.GROUP_OPEN, Token.GROUP_OPEN, Token.GROUP_OPEN, Token.GROUP_CLOSE, Token.GROUP_CLOSE, Token.GROUP_CLOSE));

        assertThat(scoreCalculator.assignScores(root)).isEqualTo(6);
    }

}
