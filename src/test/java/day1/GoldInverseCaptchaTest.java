package day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class GoldInverseCaptchaTest {

    @Parameterized.Parameters(name = "\"{0}\" => {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"1212", 6},
                {"1221", 0},
                {"123425", 4},
                {"123123", 12},
                {"12131415", 4}
        });
    }

    private final String captcha;

    private final int expected;

    public GoldInverseCaptchaTest(String captcha, int expected) {
        this.captcha = captcha;
        this.expected = expected;
    }

    @Test
    public void testInputs() {
        InverseCaptcha captcha = new InverseCaptcha(this.captcha.length() / 2);
        assertThat(captcha.compute(this.captcha)).isEqualTo(expected);
    }

}
