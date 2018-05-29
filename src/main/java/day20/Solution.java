package day20;

import common.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day20/particles.txt")) {
            List<Particle> particles = reader.lines()
                    .map(ParticleParser::parse)
                    .collect(Collectors.toList());

            List<Particle> sorted = new ArrayList<>(particles);
            sorted.sort(Comparator.comparing(Particle::absoluteAcceleration).thenComparing(Particle::absoluteVelocity));

            Particle closestParticle = sorted.get(0);
            System.out.println("Closest particle should be " + particles.indexOf(closestParticle));
        }
    }

}
