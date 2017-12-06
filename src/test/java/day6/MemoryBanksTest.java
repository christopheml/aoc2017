package day6;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryBanksTest {

    @Test
    public void test_simple_cycle() {
        MemoryBanks banks = MemoryBanks.of(new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 16);
        banks.cycle();
        assertThat(banks.dump()).containsExactly(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Test
    public void acceptance_test() {
        MemoryBanks banks = MemoryBanks.of(new int[]{0, 2, 7, 0}, 4);
        banks.cycle();
        assertThat(banks.dump()).containsExactly(2, 4, 1, 2).as("Acceptance: first cycle");
        banks.cycle();
        assertThat(banks.dump()).containsExactly(3, 1, 2, 3).as("Acceptance: second cycle");
        banks.cycle();
        assertThat(banks.dump()).containsExactly(0, 2, 3, 4).as("Acceptance: third cycle");
        banks.cycle();
        assertThat(banks.dump()).containsExactly(1, 3, 4, 1).as("Acceptance: fourth cycle");
        banks.cycle();
        assertThat(banks.dump()).containsExactly(2, 4, 1, 2).as("Acceptance: fifth cycle");
    }

}
