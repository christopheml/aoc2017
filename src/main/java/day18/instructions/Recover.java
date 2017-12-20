package day18.instructions;

import day18.SoundVirtualMachine;

import java.util.function.Function;

public class Recover implements Instruction {

    private final Function<SoundVirtualMachine, Long> condition;

    public Recover(Function<SoundVirtualMachine, Long> condition) {
        this.condition = condition;
    }


    @Override
    public void accept(SoundVirtualMachine virtualMachine) {
        if (condition.apply(virtualMachine) > 0) {
            virtualMachine.recover();
        }
    }

}
