package day18;

import java.util.function.Supplier;

public class Parser {

    public Instruction parse(String input) {
        String[] parts = input.split(" ");
        switch (parts[0]) {
            case "snd":
                return sound(argument(parts[1]));
            case "set":
            case "add":
            case "mul":
            case "mod":
            case "rcv":
                return recover(argument(parts[1]));
            case "jgz":
            default:
                throw new UnsupportedOperationException("Unknown instruction " + parts[0]);
        }
    }

    private Supplier<Integer> argument(String part) {
        return () -> Integer.valueOf(part);
    }

    private Instruction recover(Supplier<Integer> argument) {
        return virtualMachine -> {
            if (argument.get() > 0) {
                virtualMachine.recover();
            }
        };
    }

    private Instruction sound(Supplier<Integer> frequency) {
        return virtualMachine -> virtualMachine.sound(frequency.get());
    }

}
