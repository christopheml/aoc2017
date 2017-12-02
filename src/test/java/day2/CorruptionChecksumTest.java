package day2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CorruptionChecksumTest {

    @Parameterized.Parameters(name = "{0} => {1}")
    public static Collection<Object[]> testData() {
        return asList(new Object[][]{
                {asList(5, 1, 9, 5), 8},
                {asList(7, 5, 3), 4},
                {asList(2, 4, 6, 8), 6},
                {asList(597, 57), 540},

        });
    }

    private final List<Integer> row;

    private final int expectedChecksum;

    public CorruptionChecksumTest(List<Integer> row, int expectedChecksum) {
        this.row = row;
        this.expectedChecksum = expectedChecksum;
    }

    @Test
    public void testInputs() {
        assertThat(CorruptionChecksum.rowChecksum(row)).isEqualTo(expectedChecksum);
    }

}
