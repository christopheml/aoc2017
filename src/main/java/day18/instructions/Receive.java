package day18.instructions;

import day18.vm.AsyncVirtualMachine;

public class Receive implements Instruction<AsyncVirtualMachine> {

    private final RegisterAccess register;

    public Receive(RegisterAccess register) {
        this.register = register;
    }

    @Override
    public void accept(AsyncVirtualMachine virtualMachine) {
        virtualMachine.receive(register.apply(virtualMachine));
    }

}
