package day18;

public class Register {

    private long value = 0;

    public long value() {
        return value;
    }

    public void set(long value) {
        this.value = value;
    }

    public void add(long offset) {
        this.value += offset;
    }

    public void multiply(long multiplier) {
        this.value *= multiplier;
    }

    public void modulo(long modulo) {
        this.value %= modulo;
    }

}
