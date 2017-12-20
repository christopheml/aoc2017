package day18.instructions;

import day18.vm.VirtualMachine;

import java.util.function.Function;

@FunctionalInterface
public interface ValueLookup extends Function<VirtualMachine, Long> {
}
