package day18.instructions;

import day18.vm.SoundVirtualMachine;
import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Sound implements Instruction<SoundVirtualMachine> {

    private final Function<VirtualMachine, Long> frequency;

    public Sound(Function<VirtualMachine, Long> frequency) {
        this.frequency = frequency;
    }

    @Override
    public void accept(SoundVirtualMachine virtualMachine) {
        virtualMachine.sound(frequency.apply(virtualMachine));
    }

}
