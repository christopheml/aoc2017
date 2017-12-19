package day18;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ParserTest {

    @Test
    public void sound() throws Exception {
        Parser parser = new Parser();
        Instruction instruction = parser.parse("snd 18");
        VirtualMachine vm = Mockito.mock(VirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(1)).sound(18);
    }

}
