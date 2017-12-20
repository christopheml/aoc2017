package day18;

import day18.instructions.Instruction;
import day18.parser.AsyncParser;
import day18.parser.Parser;
import day18.vm.AsyncVirtualMachine;
import day18.vm.Register;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AsyncParserTest {

    private final Parser parser = new AsyncParser();

    @Test
    public void send_value() throws Exception {
        Instruction instruction = parser.parse("snd 18");
        AsyncVirtualMachine vm = mock(AsyncVirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(1)).send(18);
    }

    @Test
    public void receive() throws Exception {
        Instruction instruction = parser.parse("rcv b");
        AsyncVirtualMachine vm = mock(AsyncVirtualMachine.class);
        Register b = register(878754);
        when(vm.register("b")).thenReturn(b);

        instruction.accept(vm);
        verify(vm, times(1)).receive(b);
    }

    private Register register(int value) {
        Register register = new Register();
        register.set(value);
        return register;
    }

}
