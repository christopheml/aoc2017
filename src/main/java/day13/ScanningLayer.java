package day13;

class ScanningLayer implements Layer {

    private final int range;
    private int position;
    private int direction;

    ScanningLayer(int range) {
        this.range = range;
        position = 0;
        direction = 1;
    }

    @Override
    public boolean probe() {
        return position == 0;
    }

    @Override
    public void tick() {
        position += direction;
        if ((position == 0) || (position == range - 1)) {
            reverse();
        }
    }

    @Override
    public int range() {
        return range;
    }

    private void reverse() {
        direction = -direction;
    }

}
