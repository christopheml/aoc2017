package day13;

public class InactiveLayer implements Layer {

    @Override
    public boolean probe(int tick) {
        return false;
    }

    @Override
    public int range() {
        return 0;
    }

}
