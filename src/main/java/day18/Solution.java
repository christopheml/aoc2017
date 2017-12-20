package day18;

import common.FileReader;
import day18.instructions.Instruction;
import day18.parser.Parser;
import day18.parser.SoundParser;
import day18.vm.FirstRecoverVirtualMachine;

import java.util.List;
import java.util.stream.Collectors;

final class Solution {

    public static void main(String... args) throws Exception {
        try (FileReader reader = FileReader.read("/day18/program.txt")) {
            Parser soundParser = new SoundParser();
            List<Instruction> program = reader.lines().map(soundParser::parse).collect(Collectors.toList());
            FirstRecoverVirtualMachine vm = new FirstRecoverVirtualMachine();
            long solution = vm.executeUntilFirstRecover(program);
            System.out.println("The first recovered frequency is: " + solution);
        }
    }

}
