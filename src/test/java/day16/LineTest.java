package day16;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void spin_one() throws Exception {
        Line line = new Line(5);
        line.spin(1);
        assertThat(line.toString()).isEqualTo("eabcd");
    }

    @Test
    public void spin_zero() throws Exception {
        Line line = new Line(5);
        line.spin(0);
        assertThat(line.toString()).isEqualTo("abcde");
    }

    @Test
    public void spin_multiple_if_line_size() throws Exception {
        Line line = new Line(5);
        line.spin(10);
        assertThat(line.toString()).isEqualTo("abcde");
    }

    @Test
    public void spin_more_than_line_size() throws Exception {
        Line line = new Line(5);
        line.spin(2);
        assertThat(line.toString()).isEqualTo("deabc");
    }

    @Test
    public void swap_positions() throws Exception {
        Line line = new Line(5);
        line.swapPositions(3, 4);
        assertThat(line.toString()).isEqualTo("abced");
    }

    @Test
    public void swap_positions_after_spin() throws Exception {
        Line line = new Line(5);
        line.spin(1);
        line.swapPositions(3, 4);
        assertThat(line.toString()).isEqualTo("eabdc");
    }

    @Test
    public void swap_programs() throws Exception {
        Line line = new Line(5);
        line.swapPrograms('b', 'e');
        assertThat(line.toString()).isEqualTo("aecdb");
    }

    @Test
    public void acceptance_test() throws Exception {
        Line line = new Line(5);
        line.spin(1);
        line.swapPositions(3, 4);
        line.swapPrograms('e', 'b');
        assertThat(line.toString()).isEqualTo("baedc");
    }

}
