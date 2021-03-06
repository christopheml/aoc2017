package day18.parser;

import day18.instructions.*;

public abstract class Parser {

    public Instruction parse(String input) {
        String[] parts = input.split(" ");
        switch (parts[0]) {
            case "set":
                return new Set(register(parts[1]), readableArgument(parts[2]));
            case "add":
                return new Add(register(parts[1]), readableArgument(parts[2]));
            case "mul":
                return new Mul(register(parts[1]), readableArgument(parts[2]));
            case "mod":
                return new Mod(register(parts[1]), readableArgument(parts[2]));
            case "jgz":
                return new Jump(readableArgument(parts[1]), readableArgument(parts[2]));
            default:
                return doParse(parts);
        }
    }

    protected abstract Instruction doParse(String[] parts);

    protected RegisterAccess register(String name) {
        return virtualMachine -> virtualMachine.register(name);
    }

    protected ValueLookup readableArgument(String argument) {
        if (argument.length() == 1 && Character.isLetter(argument.charAt(0))) {
            return virtualMachine -> virtualMachine.register(argument).value();
        }
        return virtualMachine -> Long.valueOf(argument);
    }

}
