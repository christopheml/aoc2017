package day18.instructions;

import day18.SoundVirtualMachine;

import java.util.function.Function;

public class Jump implements Instruction {

    private final Function<SoundVirtualMachine, Long> condition;

    private final Function<SoundVirtualMachine, Long> offset;

    public Jump(Function<SoundVirtualMachine, Long> condition, Function<SoundVirtualMachine, Long> offset) {
        this.condition = condition;
        this.offset = offset;
    }

    @Override
    public void accept(SoundVirtualMachine virtualMachine) {
        if (condition.apply(virtualMachine) > 0) {
            virtualMachine.jump(offset.apply(virtualMachine));
        }
    }

}
