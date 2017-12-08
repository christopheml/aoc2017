package day2;

import common.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) {
        Spreadsheet input = readSpreadsheet("/day2/speadsheet.txt");
        int checksum = input.checksum(CorruptionChecksum::rowChecksum, Integer::sum);
        System.out.println("Checksum is " + checksum);

        int advancedChecksum = input.checksum(AdvancedCorruptionChecksum::rowChecksum, Integer::sum);
        System.out.println("Advanced checksum is " + advancedChecksum);
    }

    private static Spreadsheet readSpreadsheet(String filename) {
        Spreadsheet spreadsheet = new Spreadsheet();
        try (FileReader reader = FileReader.read(filename)) {
            reader.lines()
                    .map(Solution::splitCells)
                    .map(Arrays::asList)
                    .map(Solution::toIntegers)
                    .forEach(spreadsheet::addRow);

        } catch (Exception e) {
            System.err.println("Error while trying to access file " + filename);
            e.printStackTrace(System.err);
        }
        return spreadsheet;
    }

    private static List<Integer> toIntegers(List<String> cells) {
        return cells.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    private static String[] splitCells(String line) {
        return line.split("\t");
    }

}
