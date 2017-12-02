package day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class InverseCaptchaTest {

    @Parameterized.Parameters(name = "\"{0}\" => {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"8", 0},
                {"1234", 0},
                {"44", 4},
                {"333", 6},
                {"1122", 3},
                {"1111", 4},
                {"91212129", 9}
        });
    }

    private final String captcha;

    private final int expected;

    public InverseCaptchaTest(String captcha, int expected) {
        this.captcha = captcha;
        this.expected = expected;
    }

    @Test
    public void testInputs() {
        assertThat(InverseCaptcha.compute(captcha)).isEqualTo(expected);
    }

}
