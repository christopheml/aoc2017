package day10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class KnotHashTest {

    @Parameterized.Parameters(name = "\"{0}\" => {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"", "a2582a3a0e66e6e86e3812dcb672a272"},
                {"AoC 2017", "33efeb34ea91902bb2f59c9920caa6cd"},
                {"1,2,3", "3efbe78a8d82f29979031a4aa0b16a9d"},
                {"1,2,4", "63960835bcdc130f0b66d7ff4f6a5a8e"}
        });
    }

    private final String input;

    private final String expectedHash;

    public KnotHashTest(String input, String expectedHash) {
        this.input = input;
        this.expectedHash = expectedHash;
    }

    @Test
    public void testInputs() {
        KnotHash knotHash = new KnotHash(input);
        String result = knotHash.compute();
        assertThat(result).isEqualTo(expectedHash);
    }

}
