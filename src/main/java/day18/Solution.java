package day18;

import common.FileReader;
import day18.instructions.Instruction;
import day18.parser.AsyncParser;
import day18.parser.Parser;
import day18.parser.SoundParser;
import day18.vm.FirstRecoverVirtualMachine;
import day18.vm.QueuedVirtualMachine;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

final class Solution {

    public static void main(String... args) throws Exception {
        firstPartSolution();
        secondPartSolution();
    }

    private static void firstPartSolution() throws Exception {
        try (FileReader reader = FileReader.read("/day18/program.txt")) {
            Parser parser = new SoundParser();
            List<Instruction> program = reader.lines().map(parser::parse).collect(Collectors.toList());
            FirstRecoverVirtualMachine vm = new FirstRecoverVirtualMachine();
            long solution = vm.executeUntilFirstRecover(program);
            System.out.println("The first recovered frequency is: " + solution);
        }
    }

    private static void secondPartSolution() throws Exception {
        try (FileReader reader = FileReader.read("/day18/program.txt")) {
            Parser parser = new AsyncParser();
            List<Instruction> program = reader.lines().map(parser::parse).collect(Collectors.toList());

            Queue<Long> a = new ArrayDeque<>();
            Queue<Long> b = new ArrayDeque<>();

            QueuedVirtualMachine vm1 = new QueuedVirtualMachine(0, a, b);
            QueuedVirtualMachine vm2 = new QueuedVirtualMachine(1, b, a);

            do {
                vm2.run(program);
                vm1.run(program);
            } while (!vm1.isBlocked() || !vm2.isBlocked());

            System.out.println("Program 1 sent " + vm2.getSendCount() + " values.");
        }
    }

}
