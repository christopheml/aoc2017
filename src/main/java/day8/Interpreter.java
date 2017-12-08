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

    void execute(String instruction) {
        Matcher matcher = INSTRUCTION_PATTERN.matcher(instruction);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid instruction: " +instruction);
        }

        Register targetRegister = registers.forName(matcher.group(1));
        String operationOperator = matcher.group(2);
        int operationOperand = Integer.valueOf(matcher.group(3));
        Consumer<Register> operation = operation(operationOperator, operationOperand);

        Register conditionRegister = registers.forName(matcher.group(4));
        String conditionOperator = matcher.group(5);
        int conditionOperand = Integer.valueOf(matcher.group(6));
        Function<Register, Boolean> condition = condition(conditionOperator, conditionOperand);

        execute(condition, conditionRegister, operation, targetRegister);
    }

    Registers getRegisters() {
        return registers;
    }

    private void execute(Function<Register, Boolean> condition, Register conditionRegister, Consumer<Register> operation, Register targetRegister) {
        if (condition.apply(conditionRegister)) {
            operation.accept(targetRegister);
        }
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
