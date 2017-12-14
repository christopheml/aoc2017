package day10;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class InnerKnotHashTest {

    @Test
    public void acceptance_test() {
        InnerKnotHash hash = new InnerKnotHash(5, asList(3, 4, 1, 5));
        hash.round();
        assertThat(hash.sample()).isEqualTo(12);
    }

}
