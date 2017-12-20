package day18.instructions;

import day18.vm.Register;
import day18.vm.VirtualMachine;

import java.util.function.Function;

public class Mod implements Instruction {

    private final Function<VirtualMachine, Register> register;

    private final Function<VirtualMachine, Long> value;

    public Mod(Function<VirtualMachine, Register> register, Function<VirtualMachine, Long> value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        register.apply(virtualMachine).modulo(value.apply(virtualMachine));
    }

}
