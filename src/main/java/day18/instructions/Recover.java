package day18.instructions;

import day18.vm.SoundVirtualMachine;
import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Recover implements Instruction {

    private final Function<VirtualMachine, Long> condition;

    public Recover(Function<VirtualMachine, Long> condition) {
        this.condition = condition;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        if (virtualMachine instanceof SoundVirtualMachine) {
            if (condition.apply(virtualMachine) > 0) {
                ((SoundVirtualMachine) virtualMachine).recover();
            }
        }
    }

}
