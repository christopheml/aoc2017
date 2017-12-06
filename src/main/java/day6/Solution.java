package day6;

public class Solution {

    public static void main(String... args) {
        MemoryBanks banks = MemoryBanks.of(new int[] {11, 11, 13, 7, 0, 15, 5, 5, 4, 4, 1, 1, 7, 1, 15, 11}, 16);
        LoopDetector loopDetector = new LoopDetector(banks);
        int steps = loopDetector.stepsUntilLoop();
        System.out.println("Cycle detected after " + steps + " steps");
    }

}
