package day18.instructions;

import day18.vm.AsyncVirtualMachine;
import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Send implements Instruction<AsyncVirtualMachine> {

    private final Function<VirtualMachine, Long> value;

    public Send(Function<VirtualMachine, Long> value) {
        this.value = value;
    }

    @Override
    public void accept(AsyncVirtualMachine virtualMachine) {
        virtualMachine.send(value.apply(virtualMachine));
    }

}
