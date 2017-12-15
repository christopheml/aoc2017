package day15;

public class PickyGenerator implements Generator {

    private final Generator generator;

    private final int multiple;

    public PickyGenerator(Generator generator, int multiple) {
        this.generator = generator;
        this.multiple = multiple;
    }

    @Override
    public int generate() {
        int value;
        do {
            value = generator.generate();
        } while ((value % multiple) != 0);
        return value;
    }

    public static Generator a(int seed) {
        return new PickyGenerator(SimpleGenerator.a(seed), 4);
    }

    public static Generator b(int seed) {
        return new PickyGenerator(SimpleGenerator.b(seed), 8);
    }

}
