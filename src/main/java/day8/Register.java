package day8;

class Register {

    private final String name;

    private int value;

    public Register(String name) {
        this.name = name;
    }

    public void increment(int offset) {
        value += offset;
    }

    public void decrement(int offset) {
        value -= offset;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("{%s: %d}", name, value);
    }

}
