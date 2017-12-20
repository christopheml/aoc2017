package day18.instructions;

import day18.Register;
import day18.VirtualMachine;

import java.util.function.Function;

public class Mul implements Instruction {

    private final Function<VirtualMachine, Register> register;

    private final Function<VirtualMachine, Integer> value;

    public Mul(Function<VirtualMachine, Register> register, Function<VirtualMachine, Integer> value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        register.apply(virtualMachine).multiply(value.apply(virtualMachine));
    }

}
