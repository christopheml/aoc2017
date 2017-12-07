package day7;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListingParserTest {

    @Test
    public void acceptance_test_testing_root() throws Exception {
        ListingParser parser = new ListingParser();
        Program root = parser.parse("/day7/acceptance.txt");
        assertThat(root.getName()).isEqualTo("tknk");
    }

}
