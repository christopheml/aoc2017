package day17;

import java.util.ArrayList;
import java.util.List;

public class Spinlock {

    private final int offset;

    private final List<Integer> values;

    private int position;

    public Spinlock(int offset, int initialCapacity) {
        this.offset = offset;
        values = new ArrayList<>(initialCapacity);
        values.add(0);
        position = 0;
    }

    public List<Integer> toList() {
        return new ArrayList<>(values);
    }

    public void insert() {
        stepForward();
        values.add(position, values.size());
    }

    private void stepForward() {
        position = ((position + offset) % values.size()) + 1;
    }

    public int getPosition() {
        return position;
    }

}
