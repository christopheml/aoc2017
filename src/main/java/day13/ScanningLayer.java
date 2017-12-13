package day13;

class ScanningLayer implements Layer {

    private final int range;
    private final int periodicity;

    ScanningLayer(int range) {
        this.range = range;
        periodicity = (range - 1) * 2;

    }

    @Override
    public boolean probe(int tick) {
        return (tick % periodicity) == 0;
    }

    @Override
    public int range() {
        return range;
    }

}
