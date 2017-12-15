package day15;

class Generator {

    private static final long MODULO = Integer.MAX_VALUE;

    private final long factor;

    private long state;

    public Generator(long seed, long factor) {
        this.state = seed;
        this.factor = factor;
    }

    public int generate() {
        state = (state * factor) % MODULO;
        return (int) state;
    }

    public static Generator a(long seed) {
        return new Generator(seed, 16807);
    }

    public static Generator b(long seed) {
        return new Generator(seed, 48271);
    }

}
