package day18;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ParserTest {

    private final Parser parser = new Parser();

    @Test
    public void sound() throws Exception {
        Instruction instruction = parser.parse("snd 18");
        VirtualMachine vm = Mockito.mock(VirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(1)).sound(18);
    }

    @Test
    public void recover_inactive() throws Exception {
        Instruction instruction = parser.parse("rcv 0");
        VirtualMachine vm = Mockito.mock(VirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(0)).recover();
    }

}
