package day11;

import common.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {

        try (FileReader reader = FileReader.read("/day11/path.txt")) {
            String input = reader.lines().findFirst().orElseThrow(IllegalStateException::new);
            PathReducer pathReducer = new PathReducer();
            List<Direction> path = pathReducer.reduce(toDirections(input));

            System.out.println("The path to the lost program has " + path.size() + " steps.");
        }

    }

    private static List<Direction> toDirections(String input) {
        String[] elements = input.toUpperCase().split(",");
        return Arrays.stream(elements).map(Direction::valueOf).collect(Collectors.toList());
    }

}
