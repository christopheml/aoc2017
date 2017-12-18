package day16;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DanceTest {

    @Test
    public void spin() throws Exception {
        Line line = mock(Line.class);
        Dance dance = new Dance("s1");
        dance.perform(line);

        verify(line).spin(1);
    }

    @Test
    public void swap_programs() throws Exception {
        Line line = mock(Line.class);
        Dance dance = new Dance("pe/b");
        dance.perform(line);

        verify(line).swapPrograms('e', 'b');
    }

    @Test
    public void swap_positions() throws Exception {
        Line line = mock(Line.class);
        Dance dance = new Dance("x3/4");
        dance.perform(line);

        verify(line).swapPositions(3, 4);
    }

    @Test
    public void multiple_commands() throws Exception {
        Line line = mock(Line.class);
        Dance dance = new Dance("s1,pe/b,x3/4");
        dance.perform(line);

        verify(line).spin(1);
        verify(line).swapPrograms('e', 'b');
        verify(line).swapPositions(3, 4);
    }

}
