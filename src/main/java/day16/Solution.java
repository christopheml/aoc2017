package day16;

import common.FileReader;

final class Solution {

    public static void main(String... args) throws Exception {
        String steps = input();
        firstPartSolution(steps);
    }

    private static void firstPartSolution(String steps) {
        Line line = new Line(16);
        Dance dance = new Dance(steps);

        long l = System.currentTimeMillis();
        dance.perform(line);
        System.out.println("Time: " + (System.currentTimeMillis() - l) + "ms");
        System.out.println("Line after dancing: " + line);
    }

    private static String input() throws Exception {
        try (FileReader reader = FileReader.read("/day16/dance.txt")) {
            return reader.lines().findFirst().orElseThrow(IllegalStateException::new);
        }
    }

}
