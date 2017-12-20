package day18.parser;

import day18.instructions.Instruction;
import day18.instructions.Receive;
import day18.instructions.Send;

public class AsyncParser extends Parser {
    @Override
    protected Instruction doParse(String[] parts) {
        switch (parts[0]) {
            case "snd":
                return new Send(readableArgument(parts[1]));
            case "rcv":
                return new Receive(register(parts[1]));
            default:
                throw new UnsupportedOperationException("Unknown instruction " + parts[0]);
        }
    }
}
