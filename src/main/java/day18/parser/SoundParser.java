package day18.parser;

import day18.instructions.*;

public class SoundParser extends Parser {

    @Override
    protected Instruction doParse(String[] parts) {
        switch (parts[0]) {
            case "snd":
                return new Sound(readableArgument(parts[1]));
            case "rcv":
                return new Recover(readableArgument(parts[1]));
            default:
                throw new UnsupportedOperationException("Unknown instruction " + parts[0]);
        }
    }

}
