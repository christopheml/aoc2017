package day13;

public class Layers {

    private static final InactiveLayer INACTIVE_LAYER = new InactiveLayer();

    private Layers() {
    }

    public static Layer scanning(int range) {
        return new ScanningLayer(range);
    }

    public static Layer inactive() {
        return INACTIVE_LAYER;
    }

}
