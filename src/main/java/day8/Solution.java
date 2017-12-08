package day8;

import common.FileReader;

import java.util.Comparator;
import java.util.stream.Collectors;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {
        Interpreter interpreter = new Interpreter();
        try (FileReader reader = FileReader.read("/day8/program.txt")) {
            interpreter.execute(reader.lines().collect(Collectors.toList()));
        }

        System.out.println(String.format("Largest register has value %d", highestRegisterValue(interpreter)));
    }


    static int highestRegisterValue(Interpreter interpreter) {
        return interpreter.getRegisters().stream().max(Comparator.comparing(Register::value)).orElseThrow(IllegalStateException::new).value();
    }

}
