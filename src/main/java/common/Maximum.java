package common;

public class Maximum {

    private int maximum = Integer.MIN_VALUE;

    public void update(int value) {
        if (value > maximum) maximum = value;
    }

    public int get() {
        return maximum;
    }

}
