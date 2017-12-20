package day18.instructions;

import day18.VirtualMachine;

import java.util.function.Function;

public class Jump implements Instruction {

    private final Function<VirtualMachine, Integer> condition;

    private final Function<VirtualMachine, Integer> offset;

    public Jump(Function<VirtualMachine, Integer> condition, Function<VirtualMachine, Integer> offset) {
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
