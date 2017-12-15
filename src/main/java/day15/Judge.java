package day15;

class Judge {

    private static final int MASK = 0x0000ffff;

    private final Generator a;

    private final Generator b;

    public Judge(Generator a, Generator b) {
        this.a = a;
        this.b = b;
    }

    public long count(long iterations) {
        long count = 0;
        for (int i = 0; i < iterations; i++) {
            int aValue = a.generate() & MASK;
            int bValue = b.generate() & MASK;
            if (aValue == bValue) {
                count++;
            }
        }
        return count;
    }

}
