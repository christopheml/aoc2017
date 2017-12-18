package day17;

public class SimulatedSpinlock {

    private final int offset;

    public SimulatedSpinlock(int offset) {
        this.offset = offset;
    }

    public int simulate(int iterations) {
        int position = 0;
        int afterZero = Integer.MIN_VALUE;
        for (int size = 1; size < (iterations + 1); ++size) {
            position = ((position + offset) % size) + 1;
            if (position == 1) {
                afterZero = size;
            }
        }
        return afterZero;
    }

}
