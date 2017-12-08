package day8;

class Register {

    private final String name;

    private int value;

    Register(String name) {
        this.name = name;
    }

    void increment(int offset) {
        value += offset;
    }

    void decrement(int offset) {
        value -= offset;
    }

    int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("{%s: %d}", name, value);
    }

}
