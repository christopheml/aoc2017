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
        Firewall firewall = getFirewall();
        firstPartSolution(firewall);
        secondPartSolution(firewall);
    }

    private static void firstPartSolution(Firewall firewall) {
        int severity = firewall.cross();
        System.out.println("Severity for crossing the firewall is: " + severity);
    }

    private static void secondPartSolution(Firewall firewall) {
        boolean caught;
        int delay = 0;
        do {
            delay++;
            caught = firewall.crossUntilCaught(delay);
        } while (caught);
        System.out.println("Safe to cross delay is: " + delay);
    }

    private static Firewall getFirewall() throws Exception {
        return new Firewall(getLayers());
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
