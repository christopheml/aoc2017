package day18;

public class Parser {

    public Instruction parse(String input) {
        String[] parts = input.split(" ");
        switch (parts[0]) {
            case "snd":
                return sound(Integer.valueOf(parts[1]));
            case "set":
            case "add":
            case "mul":
            case "mod":
            case "rcv":
            case "jgz":
            default:
                throw new UnsupportedOperationException("Unknown instruction " + parts[0]);
        }
    }

    private Instruction sound(int frequency) {
        return virtualMachine -> virtualMachine.sound(frequency);
    }

}
