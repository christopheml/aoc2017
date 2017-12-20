package day18.instructions;

import day18.vm.AsyncVirtualMachine;

public class Send implements Instruction<AsyncVirtualMachine> {

    private final ValueLookup value;

    public Send(ValueLookup value) {
        this.value = value;
    }

    @Override
    public void accept(AsyncVirtualMachine virtualMachine) {
        virtualMachine.send(value.apply(virtualMachine));
    }

}
