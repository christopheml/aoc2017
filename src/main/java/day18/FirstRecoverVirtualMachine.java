package day18;

import day18.instructions.Instruction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstRecoverVirtualMachine implements VirtualMachine {

    private final Map<String, Register> registers = new HashMap<>();

    private int pointer;

    boolean jumped;

    boolean recovered;

    private int frequency;

    public int executeUntilFirstRecover(List<Instruction> program) {
        pointer = 0;

        while (pointer >= 0 && pointer < program.size()) {
            program.get(pointer).accept(this);

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
        return registers.computeIfAbsent(name, n -> new Register());
    }

    @Override
    public void recover() {
        recovered = true;
    }

    @Override
    public void jump(int offset) {
        System.out.println("Jumping to " + offset);
        pointer += offset;
        jumped = true;
    }

}
