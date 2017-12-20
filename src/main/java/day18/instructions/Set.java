package day18.instructions;

import day18.Register;
import day18.SoundVirtualMachine;

import java.util.function.Function;

public class Set implements Instruction {

    private final Function<SoundVirtualMachine, Register> register;

    private final Function<SoundVirtualMachine, Long> value;

    public Set(Function<SoundVirtualMachine, Register> register, Function<SoundVirtualMachine, Long> value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void accept(SoundVirtualMachine virtualMachine) {
        register.apply(virtualMachine).set(value.apply(virtualMachine));
    }

}
