package day18;

import java.util.function.Function;

public class Parser {

    public Instruction parse(String input) {
        String[] parts = input.split(" ");
        switch (parts[0]) {
            case "snd":
                return sound(readableArgument(parts[1]));
            case "set":
                return set(register(parts[1]), readableArgument(parts[2]));
            case "add":
                return add(register(parts[1]), readableArgument(parts[2]));
            case "mul":
                return mul(register(parts[1]), readableArgument(parts[2]));
            case "mod":
                return mod(register(parts[1]), readableArgument(parts[2]));
            case "rcv":
                return recover(readableArgument(parts[1]));
            case "jgz":
            default:
                throw new UnsupportedOperationException("Unknown instruction " + parts[0]);
        }
    }

    private Instruction mod(Function<VirtualMachine, Register> register, Function<VirtualMachine, Integer> value) {
        return virtualMachine -> register.apply(virtualMachine).modulo(value.apply(virtualMachine));
    }

    private Instruction mul(Function<VirtualMachine, Register> register, Function<VirtualMachine, Integer> value) {
        return virtualMachine -> register.apply(virtualMachine).multiply(value.apply(virtualMachine));
    }

    private Instruction add(Function<VirtualMachine, Register> register, Function<VirtualMachine, Integer> value) {
        return virtualMachine -> register.apply(virtualMachine).add(value.apply(virtualMachine));
    }

    private Instruction set(Function<VirtualMachine, Register> register, Function<VirtualMachine, Integer> value) {
        return virtualMachine -> register.apply(virtualMachine).set(value.apply(virtualMachine));
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

    private Instruction recover(Function<VirtualMachine, Integer> argument) {
        return virtualMachine -> {
            if (argument.apply(virtualMachine) > 0) {
                virtualMachine.recover();
            }
        };
    }

    private Instruction sound(Function<VirtualMachine, Integer> frequency) {
        return virtualMachine -> virtualMachine.sound(frequency.apply(virtualMachine));
    }

}
