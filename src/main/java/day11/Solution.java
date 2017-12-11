package day11;

import common.FileReader;
import common.Maximum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {

        try (FileReader reader = FileReader.read("/day11/path.txt")) {
            String input = reader.lines().findFirst().orElseThrow(IllegalStateException::new);

            firstPartSolution(input);
            secondPartSolution(input);
        }

    }

    private static void firstPartSolution(String input) {
        PathReducer pathReducer = new PathReducer();
        List<Direction> path = pathReducer.reduce(toDirections(input));

        System.out.println("The path to the lost program has " + path.size() + " steps.");
    }

    private static void secondPartSolution(String input) {
        PathReducer pathReducer = new PathReducer();
        List<Direction> toWalk = toDirections(input);
        List<Direction> walked = new LinkedList<>();
        Maximum maximum = new Maximum();
        while (!toWalk.isEmpty()) {
            walked.add(toWalk.remove(0));
            pathReducer.reduceInPlace(walked);
            maximum.update(walked.size());
        }

        System.out.println("The furthest distance from the starting position was: " + maximum.get());
    }

    private static List<Direction> toDirections(String input) {
        String[] elements = input.toUpperCase().split(",");
        return Arrays.stream(elements).map(Direction::valueOf).collect(Collectors.toList());
    }

}
