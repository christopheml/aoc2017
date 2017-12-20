package day18;

import java.util.Queue;

public class QueuedVirtualMachine implements AsyncVirtualMachine {

    private final Registers registers = new Registers();

    private final Queue<Long> input;

    private final Queue<Long> output;

    private long pointer;

    private boolean jumped;

    public QueuedVirtualMachine(Queue<Long> input, Queue<Long> output) {
        this.input = input;
        this.output = output;
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
            // blocked
        }
    }

    @Override
    public void jump(long offset) {
        pointer += offset;
        jumped = true;
    }

}
