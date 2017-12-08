package day8;

import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InterpreterTest {

    @Test
    public void invalid_instruction_is_rejected() throws Exception {
        Interpreter interpreter = new Interpreter();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> interpreter.execute(Collections.singletonList("garbage"))
        ).withMessage("Invalid statement: garbage");
    }

    @Test
    public void acceptance() throws Exception {
        Interpreter interpreter = new Interpreter();
        interpreter.execute(asList(
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10"
        ));
        assertThat(interpreter.getRegisters().highest().value()).isEqualTo(1);
    }

}
