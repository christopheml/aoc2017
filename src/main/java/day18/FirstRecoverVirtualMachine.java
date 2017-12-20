package day18;

import day18.instructions.Instruction;

import java.util.List;

public class FirstRecoverVirtualMachine implements VirtualMachine {

    private final Registers registers = new Registers();

    private int pointer;

    private boolean jumped;

    private boolean recovered;

    private int frequency;

    public int executeUntilFirstRecover(List<Instruction> program) {
        pointer = 0;

        while (pointer >= 0 && pointer < program.size()) {
            Instruction instruction = program.get(pointer);
            int position = pointer;
            instruction.accept(this);
            System.out.println("[" + position + "] " + instruction.getClass().getSimpleName() + " " + registers);

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
    public void sound(int frequency) {
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
    public void jump(int offset) {
        pointer += offset;
        jumped = true;
    }

}
