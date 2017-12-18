package day16;

import common.FileReader;

final class Solution {

    public static void main(String... args) throws Exception {
        String steps = input();
        firstPartSolution(steps);
        secondPartSolution(steps);
    }

    private static void firstPartSolution(String steps) {
        Line line = new Line(16);
        Dance dance = new Dance(steps);

        dance.perform(line);
        System.out.println("Line after dancing: " + line);
    }

    private static void secondPartSolution(String steps) {
        Dance dance = new Dance(steps);

        int cycle = cycleSize(dance);

        Line line = new Line(16);
        int iterations = 1000000000;

        for (int i = 0; i < (iterations % cycle); ++i) {
            dance.perform(line);
        }

        System.out.println("Line after dancing " + iterations + " iterations: " + line);
    }

    private static int cycleSize(Dance dance) {
        int iteration = 0;
        Line line = new Line(16);
        do {
            dance.perform(line);
            iteration++;
        } while (!line.isInitialState());
        System.out.println("Loop detected after " + iteration + " iterations");
        return iteration;
    }

    private static String input() throws Exception {
        try (FileReader reader = FileReader.read("/day16/dance.txt")) {
            return reader.lines().findFirst().orElseThrow(IllegalStateException::new);
        }
    }

}
