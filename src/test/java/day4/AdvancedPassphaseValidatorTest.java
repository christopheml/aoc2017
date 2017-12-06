package day4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class AdvancedPassphaseValidatorTest {

    @Parameterized.Parameters(name = "{0}: {1}")
    public static Collection<Object[]> testData() {
        return asList(new Object[][] {
                {"abcde fghij", true},
                {"abcde xyz ecdab", false},
                {"a ab abc abd abf abj", true},
                {"iiii oiii ooii oooi oooo", true},
                {"oiii ioii iioi iiio", false}
        });
    }

    private final String passphrase;

    private final boolean expectedValidity;

    public AdvancedPassphaseValidatorTest(String passphrase, boolean expectedValidity) {
        this.passphrase = passphrase;
        this.expectedValidity = expectedValidity;
    }

    @Test
    public void testInputs() {
        AdvancedPassphaseValidator validator = new AdvancedPassphaseValidator();
        assertThat(validator.isValid(passphrase)).isEqualTo(expectedValidity);
    }

}
