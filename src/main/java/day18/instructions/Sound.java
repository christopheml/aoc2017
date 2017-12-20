package day18.instructions;

import day18.SoundVirtualMachine;

import java.util.function.Function;

public class Sound implements Instruction {

    private final Function<SoundVirtualMachine, Long> frequency;

    public Sound(Function<SoundVirtualMachine, Long> frequency) {
        this.frequency = frequency;
    }

    @Override
    public void accept(SoundVirtualMachine virtualMachine) {
        virtualMachine.sound(frequency.apply(virtualMachine));
    }

}
