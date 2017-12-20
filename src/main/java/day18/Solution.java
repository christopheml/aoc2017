package day18;

import common.FileReader;
import day18.instructions.Instruction;

import java.util.List;
import java.util.stream.Collectors;

final class Solution {

    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day18/program.txt")) {
            Parser parser = new Parser();
            List<Instruction> program = reader.lines().map(parser::parse).collect(Collectors.toList());
            FirstRecoverVirtualMachine vm = new FirstRecoverVirtualMachine();
            int solution = vm.executeUntilFirstRecover(program);
            System.out.println("The first recovered frequency is: " + solution);
        }
    }

}
