package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class FileReader implements AutoCloseable {

    private final BufferedReader reader;

    private FileReader(String relativePath) {
        reader = new BufferedReader(new InputStreamReader(FileReader.class.getResourceAsStream(relativePath)));
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }

    public Stream<String> lines() {
        return reader.lines();
    }

    public static FileReader read(String relativePath) {
        return new FileReader(relativePath);
    }

}
