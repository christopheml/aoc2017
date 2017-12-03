package day2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class GoldCorruptionChecksum {

    private GoldCorruptionChecksum() {
    }

    public static int rowChecksum(List<Integer> row) {
        Integer[] values = row.toArray(new Integer[row.size()]);
        Arrays.sort(values, Comparator.reverseOrder());
        for (int i = 0; i < values.length; i++) {
            int current = values[i];
            for (int j = 0; j < values.length; j++) {
                if (i != j) {
                    int candidate = values[j];
                    if (current % candidate == 0) {
                        return current / candidate;
                    }
                }
            }
        }
        throw new IllegalStateException();
    }

}
