package day15;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {

    @Test
    public void acceptance_fast() throws Exception {
        Generator a = SimpleGenerator.a(65);
        Generator b = SimpleGenerator.b(8921);
        Judge judge = new Judge(a, b);
        long count = judge.count(5);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void acceptance_slow() throws Exception {
        Generator a = SimpleGenerator.a(65);
        Generator b = SimpleGenerator.b(8921);
        Judge judge = new Judge(a, b);
        long count = judge.count(40000000);
        assertThat(count).isEqualTo(588);
    }

    @Test
    public void acceptance_picky_fast() throws Exception {
        Generator a = PickyGenerator.a(65);
        Generator b = PickyGenerator.b(8921);
        Judge judge = new Judge(a, b);
        long count = judge.count(5);
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void acceptance_picky_slow() throws Exception {
        Generator a = PickyGenerator.a(65);
        Generator b = PickyGenerator.b(8921);
        Judge judge = new Judge(a, b);
        long count = judge.count(5000000);
        assertThat(count).isEqualTo(309);
    }

}
