package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

class Spreadsheet {

    private final List<List<Integer>> rows;

    Spreadsheet() {
        rows = new ArrayList<>();
    }

    void addRow(List<Integer> row) {
        rows.add(row);
    }

    int checksum(Function<List<Integer>, Integer> rowChecksum, BinaryOperator<Integer> accumulator) {
        return rows.stream().map(rowChecksum).reduce(0, accumulator);
    }

}
