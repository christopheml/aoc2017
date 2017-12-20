package day18.instructions;

import day18.Register;
import day18.VirtualMachine;

import java.util.function.Function;

public class Set implements Instruction {

    private final Function<VirtualMachine, Register> register;

    private final Function<VirtualMachine, Integer> value;

    public Set(Function<VirtualMachine, Register> register, Function<VirtualMachine, Integer> value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        register.apply(virtualMachine).set(value.apply(virtualMachine));
    }

}
