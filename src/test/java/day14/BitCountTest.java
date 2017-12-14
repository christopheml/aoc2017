package day14;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BitCountTest {

    private final BitCount bitCount = new BitCount();

    @Parameters(name = "{0} => {1}")
    public static Collection<Object[]> testData() {
        return asList(new Object[][] {
                {"ff", 8},
                {"0", 0},
                {"03", 2},
                {"a0c2017", 9},
        });
    }

    private final String hexadecimal;

    private final int count;

    public BitCountTest(String hexadecimal, Integer count) {
        this.hexadecimal = hexadecimal;
        this.count = count;
    }

    @Test
    public void runTests() throws Exception {
        assertThat(bitCount.count(hexadecimal)).isEqualTo(count);
    }

}
