package day8;

import common.FileReader;

import java.util.Comparator;
import java.util.stream.Collectors;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {
        Registers registers = new Registers(MaximumAwareRegister::new);
        Interpreter interpreter = new Interpreter(registers);
        try (FileReader reader = FileReader.read("/day8/program.txt")) {
            interpreter.execute(reader.lines().collect(Collectors.toList()));
        }

        System.out.println(String.format("Largest register value is %d", highestRegisterValue(interpreter)));
        System.out.println(String.format("Largest register value during execition is %d", highestRegisterValueAllTime(interpreter)));
    }

    static int highestRegisterValue(Interpreter interpreter) {
        return interpreter.getRegisters().stream()
                .max(Comparator.comparing(Register::value))
                .orElseThrow(IllegalStateException::new)
                .value();
    }

    static int highestRegisterValueAllTime(Interpreter interpreter) {
        return interpreter.getRegisters().stream()
                .filter(MaximumAwareRegister.class::isInstance)
                .map(MaximumAwareRegister.class::cast)
                .max(Comparator.comparing(MaximumAwareRegister::maximumValue))
                .orElseThrow(IllegalStateException::new)
                .maximumValue();
    }

}
