package day20;

import java.util.Objects;

public class Parameter {

    private final long x;

    private final long y;

    private final long z;

    private Parameter(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Parameter apply(Parameter other) {
        return new Parameter(x + other.x, y + other.y, z + other.z);
    }

    public long distanceFromOrigin() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    public static Parameter p(long x, long y, long z) {
        return new Parameter(x, y, z);
    }

    public static Parameter p(String x, String y, String z) {
        return new Parameter(Long.parseLong(x), Long.parseLong(y), Long.parseLong(z));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parameter parameter = (Parameter) o;
        return x == parameter.x &&
                y == parameter.y &&
                z == parameter.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Parameter{x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public boolean hasSameDirectionAs(Parameter other) {
        return isSameSign(x, other.x) && isSameSign(y, other.y) && isSameSign(z, other.z);
    }

    private boolean isSameSign(long a, long b) {
        return a == 0 || b == 0 || Math.signum(a) == Math.signum(b);
    }

}
