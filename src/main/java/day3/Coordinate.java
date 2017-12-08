package day3;

final class Coordinate {

    final int x;

    final int y;

    static Coordinate origin() {
        return new Coordinate(0, 0);
    }

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinate left() {
        return new Coordinate(x - 1, y);
    }

    Coordinate right() {
        return new Coordinate(x + 1, y);
    }

    Coordinate up() {
        return new Coordinate(x, y - 1);
    }

    Coordinate down() {
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
