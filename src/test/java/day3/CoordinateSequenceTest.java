package day3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateSequenceTest {

    @Test
    public void first_step_is_origin() {
        CoordinateSequence sequence = new CoordinateSequence();
        Coordinate position = sequence.getPosition();
        assertThat(position.x).isEqualTo(0);
        assertThat(position.y).isEqualTo(0);
        assertThat(sequence.getStep()).isEqualTo(1);
    }

}
