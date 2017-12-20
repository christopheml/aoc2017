package day18.instructions;

import day18.vm.AsyncVirtualMachine;
import day18.vm.Register;
import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Receive implements Instruction {

    private final Function<VirtualMachine, Register> register;

    public Receive(Function<VirtualMachine, Register> register) {
        this.register = register;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        if (virtualMachine instanceof AsyncVirtualMachine) {
            ((AsyncVirtualMachine) virtualMachine).receive(register.apply(virtualMachine));
        }
    }

}
