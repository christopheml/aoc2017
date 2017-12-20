package day18.instructions;

import day18.VirtualMachine;

import java.util.function.Function;

public class Recover implements Instruction {

    private final Function<VirtualMachine, Integer> condition;

    public Recover(Function<VirtualMachine, Integer> condition) {
        this.condition = condition;
    }


    @Override
    public void accept(VirtualMachine virtualMachine) {
        if (condition.apply(virtualMachine) > 0) {
            virtualMachine.recover();
        }
    }

}
