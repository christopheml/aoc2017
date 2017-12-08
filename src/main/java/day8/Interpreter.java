package day8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Interpreter {

    private static final Pattern INSTRUCTION_PATTERN = Pattern.compile("^([a-z]+) (inc|dec) (-?\\d+) if ([a-z]+) (<|>|<=|>=|==|!=) (-?\\d+)$");
    private final Registers registers;

    Interpreter() {
        registers = new Registers();
    }

    void execute(String statement) {
        Matcher matcher = INSTRUCTION_PATTERN.matcher(statement);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid statement: " + statement);
        }

        Register targetRegister = registers.forName(matcher.group(1));
        Register conditionRegister = registers.forName(matcher.group(4));

        Consumer<Register> operation = operation(matcher.group(2), Integer.valueOf(matcher.group(3)));
        Function<Register, Boolean> condition = condition(matcher.group(5), Integer.valueOf(matcher.group(6)));

        Runnable instruction = execute(condition, conditionRegister, operation, targetRegister);
        instruction.run();
    }

    Registers getRegisters() {
        return registers;
    }

    private Runnable execute(Function<Register, Boolean> condition, Register conditionRegister, Consumer<Register> operation, Register targetRegister) {
        return () -> {
            if (condition.apply(conditionRegister)) {
                operation.accept(targetRegister);
            }
        };
    }

    private Consumer<Register> operation(String operator, int value) {
        switch (operator) {
            case "inc":
                return register -> register.increment(value);
            case "dec":
                return register -> register.decrement(value);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private Function<Register, Boolean> condition(String operator, int value) {
        switch (operator) {
            case "==":
                return register -> register.value() == value;
            case "!=":
                return register -> register.value() != value;
            case ">":
                return register -> register.value() > value;
            case ">=":
                return register -> register.value() >= value;
            case "<":
                return register -> register.value() < value;
            case "<=":
                return register -> register.value() <= value;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

}
