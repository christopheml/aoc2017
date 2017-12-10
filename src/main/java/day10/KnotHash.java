package day10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class KnotHash {

    private final CircularList<Integer> values;

    private final List<Integer> lengths;

    private int skipSize;

    private int position;

    KnotHash(int complexity, List<Integer> lengths) {
        this.lengths = lengths;
        values = new CircularList<>(integerRange(complexity));
        skipSize = 0;
        position = 0;
    }

    public int compute() {
        preventReuse();
        for (int length : lengths) {
            reverseSlice(length);
            skipTo(length);
        }
        return values.get(0) * values.get(1);
    }

    private void reverseSlice(int length) {
        if (length < 2) {
            // reverseSlice(0) and reverseSlice(1) are no-op by definition
            return;
        }

        for (int i = 0; i <= (length - 1) / 2; ++i) {
            values.swap(position + i, position + length - 1 - i);
        }
    }

    private void skipTo(int sliceSize) {
        position = position + sliceSize + skipSize;
        skipSize++;
    }

    private void preventReuse() {
        if (skipSize > 0) {
            throw new IllegalStateException("KnotHash objects cannot be reused");
        }
    }

    private List<Integer> integerRange(int complexity) {
        return IntStream.range(0, complexity).boxed().collect(Collectors.toList());
    }

}
