package day10;

import static java.util.Arrays.asList;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) {
        InnerKnotHash partialHash = new InnerKnotHash(256,
                asList(212, 254, 178, 237, 2, 0, 1, 54, 167, 92, 117, 125, 255, 61, 159, 164));
        partialHash.round();
        int sample = partialHash.sample();
        System.out.println("Hash sample is: " + sample);

        KnotHash knotHash = new KnotHash("212,254,178,237,2,0,1,54,167,92,117,125,255,61,159,164");
        String hash = knotHash.compute();
        System.out.println("Hash value is: " + hash);
    }

}
