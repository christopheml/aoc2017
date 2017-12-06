package day2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class AdvancedCorruptionChecksumTest {

    @Parameterized.Parameters(name = "{0} => {1}")
    public static Collection<Object[]> testData() {
        return asList(new Object[][]{
                {asList(5, 9, 2, 8), 4},
                {asList(9, 4, 7, 3), 3},
                {asList(3, 8, 6, 5), 2},
        });
    }

    private final List<Integer> row;

    private final int expectedChecksum;

    public AdvancedCorruptionChecksumTest(List<Integer> row, int expectedChecksum) {
        this.row = row;
        this.expectedChecksum = expectedChecksum;
    }

    @Test
    public void testInputs() {
        assertThat(AdvancedCorruptionChecksum.rowChecksum(row)).isEqualTo(expectedChecksum);
    }

}
