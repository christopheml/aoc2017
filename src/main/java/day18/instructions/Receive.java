package day18.instructions;

import day18.vm.AsyncVirtualMachine;
import day18.vm.Register;
import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Receive implements Instruction<AsyncVirtualMachine> {

    private final Function<VirtualMachine, Register> register;

    public Receive(Function<VirtualMachine, Register> register) {
        this.register = register;
    }

    @Override
    public void accept(AsyncVirtualMachine virtualMachine) {
        virtualMachine.receive(register.apply(virtualMachine));
    }

}
