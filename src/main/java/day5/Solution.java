package day5;

import common.FileReader;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day5/maze.txt")) {
            int[] input = reader.lines()
                    .map(Integer::valueOf)
                    .mapToInt(Integer::intValue)
                    .toArray();
            runSimpleMaze(input);
            runAdvancedMaze(input);
        }
    }

    private static void runSimpleMaze(int[] input) {
        Maze maze = Maze.simpleMaze(input);
        int steps = maze.run();
        System.out.println("Exited maze in " + steps + " steps");
    }

    private static void runAdvancedMaze(int[] input) {
        Maze maze = Maze.advancedMaze(input);
        int steps = maze.run();
        System.out.println("Exited advanced maze in " + steps + " steps");
    }

}
