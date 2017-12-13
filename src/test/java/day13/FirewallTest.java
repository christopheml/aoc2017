package day13;

import org.junit.Test;

import static day13.Layers.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class FirewallTest {

    @Test
    public void single_layer() {
        Firewall firewall = new Firewall(singletonList(new ScanningLayer(5)));
        int severity = firewall.cross();
        assertThat(severity).isEqualTo(0);
    }

    @Test
    public void first_part_acceptance_test() {
        Firewall firewall = new Firewall(asList(
               scanning(3),
               scanning(2),
               inactive(),
               inactive(),
               scanning(4),
               inactive(),
               scanning(4)
        ));

        int severity = firewall.cross();
        assertThat(severity).isEqualTo(24);
    }

    @Test
    public void second_part_acceptance_test() throws Exception {
        Firewall firewall = new Firewall(asList(
                scanning(3),
                scanning(2),
                inactive(),
                inactive(),
                scanning(4),
                inactive(),
                scanning(4)
        ));

        boolean caught;
        int delay = 0;
        do {
            delay++;
            caught = firewall.crossUntilCaught(delay);
        } while (caught);

        assertThat(delay).isEqualTo(10);
    }
}
