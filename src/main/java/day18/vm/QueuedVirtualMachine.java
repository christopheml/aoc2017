package day18.vm;

import day18.instructions.Instruction;

import java.util.List;
import java.util.Queue;

public class QueuedVirtualMachine implements AsyncVirtualMachine {

    private final Registers registers = new Registers();

    private final Queue<Long> input;

    private final Queue<Long> output;

    private int pointer = 0;

    private boolean jumped;

    private boolean blocked;

    private final int identifier;

    public QueuedVirtualMachine(int identifier, Queue<Long> input, Queue<Long> output) {
        this.identifier = identifier;
        this.input = input;
        this.output = output;
        registers.get("p").set(identifier);
    }

    public boolean run(List<Instruction> program) {
        while (!blocked && pointer >= 0 && pointer < program.size()) {
            Instruction instruction = program.get(pointer);
            instruction.accept(this);

            if (!jumped) {
                pointer++;
            }
            jumped = false;
        }
        return blocked;
    }

    @Override
    public void send(long frequency) {
        output.add(frequency);
    }

    @Override
    public Register register(String name) {
        return registers.get(name);
    }

    @Override
    public void receive(Register register) {
        if (!input.isEmpty()) {
            register.set(input.remove());
        } else {
            blocked = true;
        }
    }

    @Override
    public void jump(long offset) {
        pointer += offset;
        jumped = true;
    }

}
