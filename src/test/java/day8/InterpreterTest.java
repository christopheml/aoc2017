package day8;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InterpreterTest {

    private static final List<String> ACCEPTANCE_PROGRAM = asList(
            "b inc 5 if a > 1",
            "a inc 1 if b < 5",
            "c dec -10 if a >= 1",
            "c inc -20 if c == 10"
    );

    @Test
    public void invalid_instruction_is_rejected() throws Exception {
        Interpreter interpreter = new Interpreter();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> interpreter.execute(Collections.singletonList("garbage"))
        ).withMessage("Invalid statement: garbage");
    }

    @Test
    public void acceptance_first_part() throws Exception {
        Interpreter interpreter = new Interpreter();
        interpreter.execute(ACCEPTANCE_PROGRAM);

        int highestValue = Solution.highestRegisterValue(interpreter);
        assertThat(highestValue).isEqualTo(1);
    }

    @Test
    public void acceptance_second_part() throws Exception {
        Registers registers = new Registers(MaximumAwareRegister::new);
        Interpreter interpreter = new Interpreter(registers);
        interpreter.execute(ACCEPTANCE_PROGRAM);

        int highestValue = Solution.highestRegisterValueAllTime(interpreter);
        assertThat(highestValue).isEqualTo(10);
    }

}
