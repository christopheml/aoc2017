package day13;

import common.FileReader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {
        List<Layer> scanners = getLayers();
        firstPartSolution(scanners);
    }

    private static void firstPartSolution(List<Layer> scanners) {
        Firewall firewall = new Firewall(scanners);
        int severity = firewall.cross();
        System.out.println("Severity for crossing the firewall is: " + severity);
    }

    private static List<Layer> getLayers() throws Exception {
        List<Layer> scanners;
        try (FileReader reader = FileReader.read("/day13/firewall.txt")) {
            Map<Integer, Layer> activeScanners = reader.lines()
                    .collect(Collectors.toMap(Solution::getKey, Solution::getValue));

            int maxDepth = activeScanners.keySet().stream().max(Integer::compareTo).orElseThrow(IllegalStateException::new);

            scanners = IntStream
                    .range(0, maxDepth + 1)
                    .mapToObj(depth -> activeScanners.computeIfAbsent(depth, v -> Layers.inactive()))
                    .collect(Collectors.toList());

        }
        return scanners;
    }

    private static Integer getKey(String input) {
        return Integer.valueOf(input.substring(0, input.indexOf(':')));
    }

    private static Layer getValue(String input) {
        int range = Integer.valueOf(input.substring(input.indexOf(':') + 2));
        return Layers.scanning(range);
    }

}
