package day20;

import java.util.Objects;

public class Particle {

    private Parameter position;

    private Parameter velocity;

    private final Parameter acceleration;

    public Particle(Parameter position, Parameter velocity, Parameter acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public long absoluteAcceleration() {
        return acceleration.distanceFromOrigin();
    }

    public long absoluteVelocity() {
        return velocity.distanceFromOrigin();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Particle particle = (Particle) o;
        return Objects.equals(position, particle.position) &&
                Objects.equals(velocity, particle.velocity) &&
                Objects.equals(acceleration, particle.acceleration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(position, velocity, acceleration);
    }
}
