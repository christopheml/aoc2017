package day12;

import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionsTest {

    @Test
    public void acceptance() throws Exception {

        Connections connections = new Connections();
        connections.add(0, 2);
        connections.add(1, 1);
        connections.add(2, 0, 3, 4);
        connections.add(3, 2, 4);
        connections.add(4, 2, 3, 6);
        connections.add(5, 6);
        connections.add(6, 4, 5);

        Collection<Integer> connectedToZero = connections.resolve(0);
        assertThat(connectedToZero).hasSize(6);
    }

}
