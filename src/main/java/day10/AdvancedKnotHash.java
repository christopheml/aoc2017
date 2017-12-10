package day10;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

class AdvancedKnotHash {

    private static final int ROUNDS = 64;
    private static final List<Integer> SEED_SUFFIX = asList(17, 31, 73, 47, 23);

    private final KnotHash hash;

    AdvancedKnotHash(String input) {
        List<Integer> seed = toSeed(input);
        hash = new KnotHash(256, seed);
    }

    public String compute() {
        for (int i = 0; i < ROUNDS; ++i) {
            hash.round();
        }
        SparseHash sparseHash = hash.sparseHash();
        DenseHash denseHash = sparseHash.toDenseHash();
        return denseHash.toString();
    }

    private List<Integer> toSeed(String input) {
        List<Integer> seed = input.chars().boxed().collect(Collectors.toList());
        seed.addAll(SEED_SUFFIX);
        return seed;
    }

}
