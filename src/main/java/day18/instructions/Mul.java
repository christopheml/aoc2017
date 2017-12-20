package day18.instructions;

import day18.vm.Register;
import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Mul implements Instruction<VirtualMachine> {

    private final Function<VirtualMachine, Register> register;

    private final Function<VirtualMachine, Long> value;

    public Mul(Function<VirtualMachine, Register> register, Function<VirtualMachine, Long> value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        register.apply(virtualMachine).multiply(value.apply(virtualMachine));
    }

}
