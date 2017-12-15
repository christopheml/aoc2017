package day15;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PickyGeneratorTest {

    @Test
    public void acceptance_generator_a() throws Exception {
        Generator a = PickyGenerator.a(65);
        List<Integer> values = generateValues(a, 5);
        assertThat(values).containsExactly(1352636452, 1992081072, 530830436, 1980017072, 740335192);
    }

    @Test
    public void acceptance_generator_b() throws Exception {
        Generator b = PickyGenerator.b(8921);
        List<Integer> values = generateValues(b, 5);
        assertThat(values).containsExactly(1233683848, 862516352, 1159784568, 1616057672, 412269392);
    }

    private List<Integer> generateValues(Generator generator, int count) {
        return IntStream.range(0, count).mapToObj(i -> generator.generate()).collect(Collectors.toList());
    }

}
