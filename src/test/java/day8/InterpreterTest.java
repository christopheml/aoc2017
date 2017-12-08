package day8;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InterpreterTest {

    @Test
    public void invalid_instruction_is_rejected() throws Exception {
        Interpreter interpreter = new Interpreter();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> interpreter.execute("garbage")
        ).withMessage("Invalid instruction: garbage");
    }

    @Test
    public void acceptance() throws Exception {
        Interpreter interpreter = new Interpreter();
        interpreter.execute("b inc 5 if a > 1");
        interpreter.execute("a inc 1 if b < 5");
        interpreter.execute("c dec -10 if a >= 1");
        interpreter.execute("c inc -20 if c == 10");
        assertThat(interpreter.getRegisters().highest().value()).isEqualTo(1);
    }

}
