package day6;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) {
        MemoryBanks banks = MemoryBanks.of(new int[] {11, 11, 13, 7, 0, 15, 5, 5, 4, 4, 1, 1, 7, 1, 15, 11}, 16);
        LoopDetector loopDetector = new LoopDetector(banks);
        int steps = loopDetector.getNextCycleSize();
        System.out.println("Cycle detected after " + steps + " steps");
        int loopSize = loopDetector.getNextCycleSize();
        System.out.println("Cycle size is " + loopSize + " steps");
    }

}
