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
    public void acceptance() {
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

}
