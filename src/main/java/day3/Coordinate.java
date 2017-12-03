package day3;

final class Coordinate {

    public final int x;

    public final int y;

    public static Coordinate origin() {
        return new Coordinate(0, 0);
    }

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate left() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate right() {
        return new Coordinate(x + 1, y);
    }

    public Coordinate up() {
        return new Coordinate(x, y - 1);
    }

    public Coordinate down() {
        return new Coordinate(x, y + 1);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
