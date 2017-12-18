package day17;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpinlockTest {

    @Test
    public void insert_empty_buffer() throws Exception {
        Spinlock spinlock = new Spinlock(3, 10);
        assertThat(spinlock.toList()).containsExactly(0);
        spinlock.insert();
        assertThat(spinlock.toList()).containsExactly(0, 1);
    }

    @Test
    public void acceptance_test() throws Exception {
        Spinlock spinlock = new Spinlock(3, 10);
        for (int i = 0; i < 9; ++i) {
            spinlock.insert();
        }
        assertThat(spinlock.toList()).containsExactly(0, 9, 5, 7, 2, 4, 3, 8, 6, 1);
    }

}
