package day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class DenseHash {

    private final Collection<Integer> values;

    DenseHash(Collection<Integer> compactedValues) {
        this.values = compactedValues;
    }

    public List<Integer> toList() {
        return new ArrayList<>(values);
    }

    @Override
    public String toString() {
        return values.stream()
                .map(Integer::toHexString)
                .map(this::zeroPad)
                .collect(Collectors.joining());
    }

    private String zeroPad(String hexadecimalRepresentation) {
        if (hexadecimalRepresentation.length() % 2 == 1) {
            return "0" + hexadecimalRepresentation;
        }
        return hexadecimalRepresentation;
    }

}
