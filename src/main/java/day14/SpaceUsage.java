package day14;

import day10.KnotHash;

public class SpaceUsage {


    private static final int DIMENSION = 128;

    private static final BitCount bitCount = new BitCount();

    private int used;

    public SpaceUsage(String input) {
        used = 0;
        for (int i = 0; i < DIMENSION; i++) {
            String hashInput = hashInput(input, i);
            KnotHash knotHash = new KnotHash(hashInput);
            String hash = knotHash.compute();
            used += bitCount.count(hash);
        }
    }

    public int used() {
        return used;
    }

    private String hashInput(String input, int rowNumber) {
        return input + "-" + rowNumber;
    }

}
