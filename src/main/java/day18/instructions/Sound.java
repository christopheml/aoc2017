package day18.instructions;

import day18.VirtualMachine;

import java.util.function.Function;

public class Sound implements Instruction {

    private final Function<VirtualMachine, Integer> frequency;

    public Sound(Function<VirtualMachine, Integer> frequency) {
        this.frequency = frequency;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        virtualMachine.sound(frequency.apply(virtualMachine));
    }

}
