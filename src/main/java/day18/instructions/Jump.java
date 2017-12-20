package day18.instructions;

import day18.vm.VirtualMachine;

public class Jump implements Instruction<VirtualMachine> {

    private final ValueLookup condition;

    private final ValueLookup offset;

    public Jump(ValueLookup condition, ValueLookup offset) {
        this.condition = condition;
        this.offset = offset;
    }

    @Override
    public void accept(VirtualMachine virtualMachine) {
        if (condition.apply(virtualMachine) > 0) {
            virtualMachine.jump(offset.apply(virtualMachine));
        }
    }

}
