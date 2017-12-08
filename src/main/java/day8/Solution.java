package day8;

import common.FileReader;

public class Solution {

    public static void main(String... args) throws Exception {
        Interpreter interpreter = new Interpreter();
        try (FileReader reader = FileReader.read("/day8/program.txt")) {
            reader.lines().forEach(interpreter::execute);
        }
        Register highest = interpreter.getRegisters().highest();
        System.out.println(String.format("Largest register has value %d", highest.value()));
    }

}
