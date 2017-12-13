package day13;

public class InactiveLayer implements Layer {

    @Override
    public boolean probe() {
        return false;
    }

    @Override
    public void tick() {
    }

    @Override
    public int range() {
        return 0;
    }

}
