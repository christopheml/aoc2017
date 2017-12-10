package day10;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CircularListTest {

    @Test
    public void access_beyond_upper_bound() {
        CircularList<Integer> list = new CircularList<>(asList(0, 1, 2, 3, 4));
        assertThat(list.get(5)).isEqualTo(0);
        assertThat(list.get(7)).isEqualTo(2);
    }

    @Test
    public void access_beyond_lower_bound() {
        CircularList<Integer> list = new CircularList<>(asList(0, 1, 2, 3, 4));
        assertThat(list.get(-1)).isEqualTo(4);
        assertThat(list.get(-6)).isEqualTo(4);
    }

    @Test
    public void swap_in_bounds() {
        CircularList<Integer> list = new CircularList<>(asList(0, 1, 2, 3, 4));
        list.swap(2, 3);
        assertThat(list).containsExactly(0, 1, 3, 2, 4);
    }

    @Test
    public void swap_out_of_bounds() {
        CircularList<Integer> list = new CircularList<>(asList(0, 1, 2, 3, 4));
        list.swap(-1, 1);
        list.swap(2, 8);
        assertThat(list).containsExactly(0, 4, 3, 2, 1);
    }

}
