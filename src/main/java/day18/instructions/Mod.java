package day18.instructions;

import day18.vm.VirtualMachine;

public class Mod implements Instruction<VirtualMachine> {

    private final RegisterAccess register;

    private final ValueLookup value;

    public Mod(RegisterAccess register, ValueLookup value) {
        this.register = register;
        this.value = value;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        register.apply(virtualMachine).modulo(value.apply(virtualMachine));
    }

}
