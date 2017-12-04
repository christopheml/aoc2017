package day4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassphraseValidatorTest {

    @Test
    public void valid_passphrase_with_unique_words() {
        PassphraseValidator validator = new PassphraseValidator();
        assertThat(validator.isValid("hello world from the 2017 advent of code")).isTrue();
    }

    @Test
    public void invalid_passphrase_with_repetition() {
        PassphraseValidator validator = new PassphraseValidator();
        assertThat(validator.isValid("hello world you are nice and you are great")).isFalse();
    }

}
