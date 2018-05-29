package day20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParticleParser {

    private static final Pattern PARTICLE_REPR = Pattern.compile(
            "p=<(-?\\d+),(-?\\d+),(-?\\d+)>, " +
            "v=<(-?\\d+),(-?\\d+),(-?\\d+)>, " +
            "a=<(-?\\d+),(-?\\d+),(-?\\d+)>"
    );

    public static Particle parse(String source) {
        Matcher matcher = PARTICLE_REPR.matcher(source);
        if (matcher.matches()) {
            Parameter position = Parameter.p(matcher.group(1), matcher.group(2), matcher.group(3));
            Parameter velocity = Parameter.p(matcher.group(4), matcher.group(5), matcher.group(6));
            Parameter acceleration = Parameter.p(matcher.group(7), matcher.group(8), matcher.group(9));
            return new Particle(position, velocity, acceleration);
        } else {
            throw new IllegalStateException("Can't parse [" + source + "]");
        }
    }

}
