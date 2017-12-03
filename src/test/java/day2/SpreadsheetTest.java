package day2;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SpreadsheetTest {

    @Test
    public void testChecksumImplementation() {
        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.addRow(asList(1, 2 , 3));
        spreadsheet.addRow(asList(4, 3));

        int checksum = spreadsheet.checksum(List::size, (a, b) -> a + b);
        assertThat(checksum).isEqualTo(5);
    }

}
