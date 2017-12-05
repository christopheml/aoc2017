package day5;

import common.FileReader;

public class Solution {


    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day5/maze.txt")) {
            int[] input = reader.lines()
                    .map(Integer::valueOf)
                    .mapToInt(Integer::intValue)
                    .toArray();
            Maze maze = new Maze(input);
            int steps = maze.run();
            System.out.println("Exited maze in " + steps + " steps");
        }
    }

}
