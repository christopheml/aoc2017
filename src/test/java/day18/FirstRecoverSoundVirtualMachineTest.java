package day18;

import day18.instructions.Instruction;
import day18.parser.Parser;
import day18.parser.SoundParser;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstRecoverSoundVirtualMachineTest {

    @Test
    public void acceptance() throws Exception {
        List<String> instructions = asList(
                "set a 1",
                "add a 2",
                "mul a a",
                "mod a 5",
                "snd a",
                "set a 0",
                "rcv a",
                "jgz a -1",
                "set a 1",
                "jgz a -2");

        Parser parser = new SoundParser();
        List<Instruction> program = instructions.stream().map(parser::parse).collect(Collectors.toList());
        FirstRecoverVirtualMachine vm = new FirstRecoverVirtualMachine();

        long recovered = vm.executeUntilFirstRecover(program);

        assertThat(recovered).isEqualTo(4);
    }

}
