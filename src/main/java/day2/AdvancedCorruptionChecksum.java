package day2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

final class AdvancedCorruptionChecksum {

    private AdvancedCorruptionChecksum() {
    }

    static int rowChecksum(List<Integer> row) {
        List<Integer> values = reverse(row);
        for (Integer current : values) {
            Integer divider = findDivider(values, current);
            if (divider != null) {
                return current / divider;
            }
        }
        throw new IllegalStateException();
    }

    private static Integer findDivider(List<Integer> values, int current) {
        for (Integer candidate : values) {
            if (current != candidate && current % candidate == 0) {
                return candidate;
            }
        }
        return null;
    }

    private static List<Integer> reverse(List<Integer> row) {
        return row.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

}
