package day8;

import java.util.function.Consumer;

class Interpreter {

    private final Registers registers;

    private final Parser parser = new Parser();

    Interpreter() {
        registers = new Registers();
    }

    void execute(String statement) {
        Consumer<Registers> instruction = parser.parse(statement);
        instruction.accept(registers);
    }

    Registers getRegisters() {
        return registers;
    }

}
