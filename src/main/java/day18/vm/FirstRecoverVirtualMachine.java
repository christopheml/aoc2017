package day18.vm;

import day18.instructions.Instruction;

import java.util.List;

public class FirstRecoverVirtualMachine implements SoundVirtualMachine {

    private final Registers registers = new Registers();

    private int pointer;

    private boolean jumped;

    private boolean recovered;

    private long frequency;

    public long executeUntilFirstRecover(List<Instruction> program) {
        pointer = 0;

        while (pointer >= 0 && pointer < program.size()) {
            Instruction instruction = program.get(pointer);
            instruction.accept(this);

            if (recovered) {
                return frequency;
            }

            if (!jumped) {
                pointer++;
            }
            jumped = false;
        }

        throw new IllegalStateException("Exited program without recovering any value");
    }

    @Override
    public void sound(long frequency) {
        this.frequency = frequency;
    }

    @Override
    public Register register(String name) {
        return registers.get(name);
    }

    @Override
    public void recover() {
        recovered = true;
    }

    @Override
    public void jump(long offset) {
        pointer += offset;
        jumped = true;
    }

}
