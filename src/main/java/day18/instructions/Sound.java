package day18.instructions;

import day18.vm.SoundVirtualMachine;

public class Sound implements Instruction<SoundVirtualMachine> {

    private final ValueLookup frequency;

    public Sound(ValueLookup frequency) {
        this.frequency = frequency;
    }

    @Override
    public void accept(SoundVirtualMachine virtualMachine) {
        virtualMachine.sound(frequency.apply(virtualMachine));
    }

}
