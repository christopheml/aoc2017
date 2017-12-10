package day10;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DenseHashTest {

    @Test
    public void acceptance_test() {
        DenseHash denseHash = new DenseHash(asList(64, 7, 255));
        assertThat(denseHash.toString()).isEqualTo("4007ff");
    }
}
