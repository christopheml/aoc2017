package day8;

public class MaximumAwareRegister extends Register {

    private int maximumValue;

    MaximumAwareRegister(String name) {
        super(name);
        this.maximumValue = Integer.MIN_VALUE;
    }

    @Override
    void increment(int offset) {
        super.increment(offset);
        updateMaximum();
    }

    @Override
    void decrement(int offset) {
        super.decrement(offset);
        updateMaximum();
    }

    private void updateMaximum() {
        if (value > maximumValue) {
            maximumValue = value;
        }
    }

    int maximumValue() {
        return maximumValue;
    }

}
