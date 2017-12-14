package day14;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpaceUsageTest {

    @Test
    public void acceptance() throws Exception {
        SpaceUsage spaceUsage = new SpaceUsage("flqrgnkx");
        assertThat(spaceUsage.used()).isEqualTo(8108);
    }

}
