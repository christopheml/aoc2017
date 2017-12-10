package day10;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SparseHashTest {

    @Test
    public void acceptance_test() {
        SparseHash hash = new SparseHash(
                asList(
                        65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22,
                        65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 38
                ));
        DenseHash denseHash = hash.toDenseHash();
        assertThat(denseHash.toList()).containsExactly(64, 112);
    }

}
