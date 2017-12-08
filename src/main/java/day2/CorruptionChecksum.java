package day2;

import java.util.List;

final class CorruptionChecksum {

    private CorruptionChecksum() {
    }

    static int rowChecksum(List<Integer> row) {
        int maximum = row.stream().max(Integer::compareTo).orElseThrow(IllegalArgumentException::new);
        int minimum = row.stream().min(Integer::compareTo).orElseThrow(IllegalArgumentException::new);
        return maximum - minimum;
    }

}
