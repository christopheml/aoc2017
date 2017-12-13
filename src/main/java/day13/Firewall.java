package day13;

import java.util.List;

class Firewall {

    private final List<Layer> scanningLayers;

    Firewall(List<Layer> scanningLayers) {
        this.scanningLayers = scanningLayers;
    }

    public int cross() {
        int severity = 0;
        for (int position = 0; position < scanningLayers.size(); ++position) {
            Layer scanningLayer = scanningLayers.get(position);
            if (scanningLayer.probe()) {
                severity += position * scanningLayer.range();
            }
            scanningLayers.forEach(Layer::tick);
        }
        return severity;
    }

}
