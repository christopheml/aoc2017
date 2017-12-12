package day12;

import common.FileReader;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Solution {

    private static final Pattern LINE_PATTERN = Pattern.compile("^(\\d+) <-> (.*)$");

    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day12/pipes.txt")) {
            Connections connections = new Connections();
            reader.lines().forEach(line -> {
                Matcher matcher = LINE_PATTERN.matcher(line);
                if (matcher.matches()) {
                    Integer origin = Integer.valueOf(matcher.group(1));
                    int[] neighbours = parseNeighbours(matcher.group(2));
                    connections.add(origin, neighbours);
                }
            });
            Collection<Integer> connectedToZero = connections.resolve(0);
            System.out.println("There are " + connectedToZero.size() + " programs connected to 0");
        }

    }

    private static int[] parseNeighbours(String input) {
        String[] asStrings = input.split(", ");
        return Arrays.stream(asStrings).mapToInt(Integer::valueOf).toArray();
    }

}
