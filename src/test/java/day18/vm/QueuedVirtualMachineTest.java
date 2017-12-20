package day18.vm;

import day18.instructions.Instruction;
import day18.instructions.Receive;
import day18.instructions.Send;
import day18.parser.AsyncParser;
import day18.parser.Parser;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class QueuedVirtualMachineTest {

    @Test
    public void receive() throws Exception {
        Queue<Long> input = new ArrayDeque<>(asList(25L, 30L));
        QueuedVirtualMachine vm = new QueuedVirtualMachine(0, input, new ArrayDeque<>());

        Register target = new Register();

        Instruction receive = new Receive(virtualMachine -> target);

        receive.accept(vm);
        assertThat(target.value()).isEqualTo(25L);
        assertThat(input).containsOnly(30L);

        receive.accept(vm);
        assertThat(target.value()).isEqualTo(30L);
        assertThat(input).isEmpty();
    }

    @Test
    public void send() throws Exception {
        Queue<Long> output = new ArrayDeque<>();
        QueuedVirtualMachine vm = new QueuedVirtualMachine(0, new ArrayDeque<>(), output);

        Instruction send = new Send(virtualMachine -> 200L);

        send.accept(vm);
        assertThat(output).containsOnly(200L);
    }

    @Test
    public void acceptance_test() throws Exception {
        Queue<Long> a = new ArrayDeque<>();
        Queue<Long> b = new ArrayDeque<>();

        QueuedVirtualMachine vm1 = new QueuedVirtualMachine(0, a, b);
        QueuedVirtualMachine vm2 = new QueuedVirtualMachine(1, b, a);

        Parser parser = new AsyncParser();
        List<Instruction> program = asList("snd 1", "snd 2", "snd p", "rcv a", "rcv b", "rcv c", "rcv d").stream().map(parser::parse).collect(Collectors.toList());

        do {
            vm1.run(program);
            vm2.run(program);
        } while (!vm1.isBlocked() || !vm2.isBlocked());

        assertThat(vm1.getSendCount()).isEqualTo(3);
    }

}
