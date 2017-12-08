package day8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Pattern INSTRUCTION_PATTERN = Pattern.compile("^([a-z]+) (inc|dec) (-?\\d+) if ([a-z]+) (<|>|<=|>=|==|!=) (-?\\d+)$");

    Consumer<Registers> parse(String statement) {
        Matcher matcher = INSTRUCTION_PATTERN.matcher(statement);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid statement: " + statement);
        }

        String targetRegister = matcher.group(1);
        String conditionRegister = matcher.group(4);

        Consumer<Register> operation = operation(matcher.group(2), Integer.valueOf(matcher.group(3)));
        Function<Register, Boolean> condition = condition(matcher.group(5), Integer.valueOf(matcher.group(6)));

        return execute(condition, conditionRegister, operation, targetRegister);
    }

    private Consumer<Registers> execute(Function<Register, Boolean> condition, String conditionRegister, Consumer<Register> operation, String targetRegister) {
        return registers -> {
            if (condition.apply(registers.forName(conditionRegister))) {
                operation.accept(registers.forName(targetRegister));
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
