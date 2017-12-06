package day6;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoopDetectorTest {

    @Test
    public void acceptance_test() {
        LoopDetector loopDetector = new LoopDetector(MemoryBanks.of(new int[]{0, 2, 7, 0}, 4));
        int stepsUntilLoop = loopDetector.stepsUntilLoop();
        assertThat(stepsUntilLoop).isEqualTo(5);
    }

}
