package day18.instructions;

import day18.vm.VirtualMachine;

import java.util.function.Consumer;

public interface Instruction<T extends VirtualMachine> extends Consumer<T> {

}
