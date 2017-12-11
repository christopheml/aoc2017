package day11;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static day11.Direction.*;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class PathReducerTest {

    @Parameters(name = "{0} => {1}")
    public static Collection<Object[]> testData() {
        return asList(new Object[][] {
                {asList(N, S), emptyList()},
                {asList(N, N, S, S, N, S), emptyList()},
                {asList(N, N, S), singletonList(N)},
                {asList(NE, SW), emptyList()},
                {asList(NW, SE), emptyList()},
                {asList(NW, NE), singletonList(N)},
                {asList(SW, SE), singletonList(S)},
                {asList(NE, NE, NE), asList(NE, NE, NE)},
                {asList(NE, NE, SW, SW), emptyList()},
                {asList(NE, NE, S, S), asList(SE, SE)},
                {asList(SE, SW, SE, SW, SW), asList(SW, S, S)}
        });
    }

    private final List<Direction> input;

    private final List<Direction> reduced;

    public PathReducerTest(List<Direction> input, List<Direction> reduced) {
        this.input = input;
        this.reduced = reduced;
    }

    @Test
    public void runTests() throws Exception {
        PathReducer reducer = new PathReducer();
        List<Direction> result = reducer.reduce(input);
        assertThat(result).containsOnlyElementsOf(reduced);
    }

}
