package day9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class StreamTokenizerTest {


    @Parameterized.Parameters(name = "{0} -> {1}")
    public static Collection<Object[]> testData() {
        return asList(new Object[][]{
                {"{}", asList(Token.GROUP_OPEN, Token.GROUP_CLOSE)},
                {"!<", asList(Token.COMMENT, Token.COMMENTED)},
                {"<!!!>>", asList(Token.GARBAGE_OPEN, Token.COMMENT, Token.COMMENTED, Token.COMMENT, Token.COMMENTED, Token.GARBAGE_CLOSE)}
        });
    }

    private final String stream;

    private final List<Token> expectedTokens;

    public StreamTokenizerTest(String stream, List<Token> expectedTokens) {
        this.stream = stream;
        this.expectedTokens = expectedTokens;
    }

    @Test
    public void runTests() {
        StreamTokenizer tokenizer = new StreamTokenizer(stream);
        List<Token> tokenize = tokenizer.tokenize();
        assertThat(tokenize).containsExactlyElementsOf(expectedTokens);
    }

}
