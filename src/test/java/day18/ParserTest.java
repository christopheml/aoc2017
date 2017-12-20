package day18;

import day18.instructions.Instruction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ParserTest {

    private final Parser parser = new Parser();

    @Test
    public void sound() throws Exception {
        Instruction instruction = parser.parse("snd 18");
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(1)).sound(18);
    }

    @Test
    public void sound_register() throws Exception {
        Instruction instruction = parser.parse("snd a");
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);
        when(vm.register("a")).thenReturn(register(10));

        instruction.accept(vm);
        verify(vm, times(1)).sound(10);
    }

    @Test
    public void recover_inactive() throws Exception {
        Instruction instruction = parser.parse("rcv 0");
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(0)).recover();
    }

    @Test
    public void recover_active() throws Exception {
        Instruction instruction = parser.parse("rcv 8");
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(1)).recover();
    }

    @Test
    public void set() throws Exception {
        Instruction instruction = parser.parse("set a 255");
        Register register = register(20);
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);
        when(vm.register("a")).thenReturn(register);

        instruction.accept(vm);
        assertThat(register.value()).isEqualTo(255);
    }

    @Test
    public void add() throws Exception {
        Instruction instruction = parser.parse("add a b");
        Register a = register(20);
        Register b = register(5);
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);
        when(vm.register("a")).thenReturn(a);
        when(vm.register("b")).thenReturn(b);

        instruction.accept(vm);
        assertThat(a.value()).isEqualTo(25);
    }

    @Test
    public void mul() throws Exception {
        Instruction instruction = parser.parse("mul d 13");
        Register register = register(5);
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);
        when(vm.register("d")).thenReturn(register);

        instruction.accept(vm);
        assertThat(register.value()).isEqualTo(65);
    }

    @Test
    public void mod() throws Exception {
        Instruction instruction = parser.parse("mod f 2");
        Register register = register(5);
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);
        when(vm.register("f")).thenReturn(register);

        instruction.accept(vm);
        assertThat(register.value()).isEqualTo(1);
    }

    @Test
    public void jump_active() throws Exception {
        Instruction instruction = parser.parse("jgz 3 2");
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(1)).jump(2);
    }

    @Test
    public void jump_inactive() throws Exception {
        Instruction instruction = parser.parse("jgz 0 10");
        SoundVirtualMachine vm = mock(SoundVirtualMachine.class);

        instruction.accept(vm);
        verify(vm, times(0)).jump(anyInt());
    }

    private Register register(int value) {
        Register register = new Register();
        register.set(value);
        return register;
    }

}
