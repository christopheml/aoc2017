package day19;

import common.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day19/maze.txt")) {
            List<String> input = reader.lines().collect(Collectors.toList());
            Maze maze = new Maze(input);
            System.out.println("Word is : " + maze.walk());
            System.out.println("Maze walked in " + maze.getSteps() + " steps.");
        }
    }

}
