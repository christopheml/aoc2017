package day18;

class Register {

    private int value = 0;

    public int value() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }

    public void add(int offset) {
        this.value += offset;
    }

    public void multiply(int multiplier) {
        this.value *= multiplier;
    }

}
