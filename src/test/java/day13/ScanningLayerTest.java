package day13;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScanningLayerTest {

    @Test
    public void probe_when_scanner_is_in_initial_position() {
        ScanningLayer scanningLayer = new ScanningLayer(3);
        assertThat(scanningLayer.probe()).isTrue();
    }

    @Test
    public void probe_after_one_tick() {
        ScanningLayer scanningLayer = new ScanningLayer(3);
        scanningLayer.tick();
        assertThat(scanningLayer.probe()).isFalse();
    }

    @Test
    public void probe_after_enough_ticks_to_loop_back() {
        ScanningLayer scanningLayer = new ScanningLayer(2);
        scanningLayer.tick();
        scanningLayer.tick();
        assertThat(scanningLayer.probe()).isTrue();
    }

}
