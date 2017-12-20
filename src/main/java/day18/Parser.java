package day18;

import day18.instructions.*;

import java.util.function.Function;

public class Parser {

    public Instruction parse(String input) {
        String[] parts = input.split(" ");
        switch (parts[0]) {
            case "snd":
                return new Sound(readableArgument(parts[1]));
            case "set":
                return new Set(register(parts[1]), readableArgument(parts[2]));
            case "add":
                return new Add(register(parts[1]), readableArgument(parts[2]));
            case "mul":
                return new Mul(register(parts[1]), readableArgument(parts[2]));
            case "mod":
                return new Mod(register(parts[1]), readableArgument(parts[2]));
            case "rcv":
                return new Recover(readableArgument(parts[1]));
            case "jgz":
                return new Jump(readableArgument(parts[1]), readableArgument(parts[2]));
            default:
                throw new UnsupportedOperationException("Unknown instruction " + parts[0]);
        }
    }

    private Function<VirtualMachine, Register> register(String name) {
        return virtualMachine -> virtualMachine.register(name);
    }

    private Function<VirtualMachine, Integer> readableArgument(String argument) {
        if (argument.length() == 1 && Character.isLetter(argument.charAt(0))) {
            return virtualMachine -> virtualMachine.register(argument).value();
        }
        return virtualMachine -> Integer.valueOf(argument);
    }

}
