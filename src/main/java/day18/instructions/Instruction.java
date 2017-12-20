package day18.instructions;

import day18.VirtualMachine;

import java.util.function.Consumer;

public interface Instruction extends Consumer<VirtualMachine> {

}
