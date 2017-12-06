package day6;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoopDetectorTest {

    @Test
    public void part_one_acceptance_test() {
        LoopDetector loopDetector = new LoopDetector(MemoryBanks.of(new int[]{0, 2, 7, 0}, 4));
        int stepsUntilLoop = loopDetector.getNextCycleSize();
        assertThat(stepsUntilLoop).isEqualTo(5);
    }

    @Test
    public void part_two_acceptance_test() {
        LoopDetector loopDetector = new LoopDetector(MemoryBanks.of(new int[]{0, 2, 7, 0}, 4));
        loopDetector.getNextCycleSize();
        int stepsUntilSecondLoop = loopDetector.getNextCycleSize();
        assertThat(stepsUntilSecondLoop).isEqualTo(4);
    }

}
