package day10;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class KnotHashTest {

    @Test
    public void acceptance_test() {
        KnotHash hash = new KnotHash(5, asList(3, 4, 1, 5));
        assertThat(hash.compute()).isEqualTo(12);
    }

}
