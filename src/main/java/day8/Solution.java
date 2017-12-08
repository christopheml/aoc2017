package day8;

import common.FileReader;

import java.util.stream.Collectors;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {
        Interpreter interpreter = new Interpreter();
        try (FileReader reader = FileReader.read("/day8/program.txt")) {
            interpreter.execute(reader.lines().collect(Collectors.toList()));
        }
        Register highest = interpreter.getRegisters().highest();
        System.out.println(String.format("Largest register has value %d", highest.value()));
    }

}
