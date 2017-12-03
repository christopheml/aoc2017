package day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateSequenceTest {

    @Test
    public void step1() {
        CoordinateSequence sequence = new CoordinateSequence();
        Coordinate position = sequence.getPosition();
        assertThat(position.x).isEqualTo(0);
        assertThat(position.y).isEqualTo(0);
        assertThat(sequence.getStep()).isEqualTo(1);
    }

    @Test
    public void step2() {
        CoordinateSequence sequence = new CoordinateSequence();
        sequence.nextStep();
        Coordinate position = sequence.getPosition();
        assertThat(position.x).isEqualTo(1);
        assertThat(position.y).isEqualTo(0);
        assertThat(sequence.getStep()).isEqualTo(2);
    }

    @Test
    public void step23() {
        CoordinateSequence sequence = new CoordinateSequence();
        while (sequence.getStep() < 23) {
            sequence.nextStep();
        }
        Coordinate position = sequence.getPosition();
        assertThat(position.x).isEqualTo(0);
        assertThat(position.y).isEqualTo(2);
        assertThat(sequence.getStep()).isEqualTo(23);
    }

}
