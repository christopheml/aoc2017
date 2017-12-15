package day15;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleGeneratorTest {

    @Test
    public void acceptance_generator_a() throws Exception {
        Generator a = SimpleGenerator.a(65);
        List<Integer> values = generateValues(a, 5);
        assertThat(values).containsExactly(1092455, 1181022009, 245556042, 1744312007, 1352636452);
    }

    @Test
    public void acceptance_generator_b() throws Exception {
        Generator b = SimpleGenerator.b(8921);
        List<Integer> values = generateValues(b, 5);
        assertThat(values).containsExactly(430625591, 1233683848, 1431495498, 137874439, 285222916);
    }

    private List<Integer> generateValues(Generator generator, int count) {
        return IntStream.range(0, count).mapToObj(i -> generator.generate()).collect(Collectors.toList());
    }

}
