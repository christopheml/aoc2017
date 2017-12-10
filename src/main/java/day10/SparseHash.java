package day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class SparseHash {

    private static final int REDUCTION_FACTOR = 16;

    private final Iterable<Integer> values;

    SparseHash(Collection<Integer> values) {
        if (values.size() % REDUCTION_FACTOR != 0) {
            throw new IllegalArgumentException("Input size must be a multiple of " + REDUCTION_FACTOR);
        }
        this.values = new ArrayList<>(values);
    }

    public DenseHash toDenseHash() {
        List<Integer> compactedValues = new ArrayList<>();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            int compactedValue = 0;
            for (int i = 0; i < 16; ++i) {
                int value = iterator.next();
                compactedValue = (compactedValue == 0) ? value : compactedValue ^ value;
            }
            compactedValues.add(compactedValue);
        }
        return new DenseHash(compactedValues);
    }

}
