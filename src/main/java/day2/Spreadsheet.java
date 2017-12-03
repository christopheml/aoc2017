package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Spreadsheet {

    private final List<List<Integer>> rows;

    public Spreadsheet() {
        rows = new ArrayList<>();
    }

    public void addRow(List<Integer> row) {
        rows.add(row);
    }

    public int checksum(Function<List<Integer>, Integer> rowChecksum, BinaryOperator<Integer> accumulator) {
        return rows.stream().map(rowChecksum).reduce(0, accumulator);
    }

}
