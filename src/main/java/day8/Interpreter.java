package day8;

import java.util.List;

class Interpreter {

    private final Registers registers;

    private final Parser parser = new Parser();

    Interpreter() {
        this(new Registers());
    }

    Interpreter(Registers registers) {
        this.registers = registers;
    }

    void execute(List<String> statement) {
        statement.stream()
                .map(parser::parse)
                .forEach(instruction -> instruction.accept(registers));
    }

    Registers getRegisters() {
        return registers;
    }

}
