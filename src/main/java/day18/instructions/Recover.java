package day18.instructions;

import day18.vm.SoundVirtualMachine;

public class Recover implements Instruction<SoundVirtualMachine> {

    private final ValueLookup condition;

    public Recover(ValueLookup condition) {
        this.condition = condition;
    }

    @Override
    public void accept(SoundVirtualMachine virtualMachine) {
        if (condition.apply(virtualMachine) > 0) {
            virtualMachine.recover();
        }
    }

}
