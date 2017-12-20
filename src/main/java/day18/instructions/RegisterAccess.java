package day18.instructions;

import day18.vm.Register;
import day18.vm.VirtualMachine;

import java.util.function.Function;

@FunctionalInterface
public interface RegisterAccess extends Function<VirtualMachine, Register> {
}
