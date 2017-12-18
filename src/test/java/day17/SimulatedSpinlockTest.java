package day17;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class SimulatedSpinlockTest {

    @Parameters(name = "{0} => {1}")
    public static Collection<Object[]> testInput() {
        return asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {5, 5},
                {6, 6},
                {7, 6},
                {10, 6},
                {11, 11},
                {12, 12}
        });
    }

    private final int iterations;

    private final int expected;

    public SimulatedSpinlockTest(int iterations, int expected) {
        this.iterations = iterations;
        this.expected = expected;
    }

    @Test
    public void runTests() throws Exception {
        SimulatedSpinlock simulatedSpinlock = new SimulatedSpinlock(359);
        int result = simulatedSpinlock.simulate(iterations);
        assertThat(result).isEqualTo(expected);
    }

}
