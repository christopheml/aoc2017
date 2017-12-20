package day18.instructions;

import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Jump implements Instruction<VirtualMachine> {

    private final Function<VirtualMachine, Long> condition;

    private final Function<VirtualMachine, Long> offset;

    public Jump(Function<VirtualMachine, Long> condition, Function<VirtualMachine, Long> offset) {
        this.condition = condition;
        this.offset = offset;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        if (condition.apply(virtualMachine) > 0) {
            virtualMachine.jump(offset.apply(virtualMachine));
        }
    }

}
