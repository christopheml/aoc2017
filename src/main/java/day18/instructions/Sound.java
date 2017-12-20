package day18.instructions;

import day18.VirtualMachine;

import java.util.function.Function;

public class Sound implements Instruction {

    private final Function<VirtualMachine, Long> frequency;

    public Sound(Function<VirtualMachine, Long> frequency) {
        this.frequency = frequency;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        virtualMachine.sound(frequency.apply(virtualMachine));
    }

}
