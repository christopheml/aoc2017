package day15;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {

    @Test
    public void acceptance_fast() throws Exception {
        Generator a = Generator.a(65);
        Generator b = Generator.b(8921);
        Judge judge = new Judge(a, b);
        long count = judge.count(5);
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void acceptance_slow() throws Exception {
        Generator a = Generator.a(65);
        Generator b = Generator.b(8921);
        Judge judge = new Judge(a, b);
        long count = judge.count(40000000);
        assertThat(count).isEqualTo(588);
    }

}
