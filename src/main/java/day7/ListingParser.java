package day7;

import common.FileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

/**
 * Parses a listing into a tree of programs.
 */
public class ListingParser {

    private static final Pattern LINE_PATTERN = Pattern.compile("([a-z]+) \\((\\d+)\\)(?: -> (.*))?");

    private final Map<String, Program> programs = new HashMap<>();

    private final Map<String, List<String>> children = new HashMap<>();

    public Program parse(String filename) throws Exception {
        init();

        parseLines(filename);

        linkChildren();

        return findRoot();
    }

    private void init() {
        programs.clear();
        children.clear();
    }

    private void parseLines(String filename) throws Exception {
        try (FileReader reader = FileReader.read(filename)) {
            reader.lines().forEach(this::parseLine);
        }
    }

    private void parseLine(String line) {
        Matcher matcher = LINE_PATTERN.matcher(line);
        if (matcher.matches()) {
            String name = matcher.group(1);
            int weight = Integer.valueOf(matcher.group(2));
            programs.put(name, new Program(name, weight));

            String childrenNames = matcher.group(3);
            if (childrenNames != null) {
                children.put(name, asList(childrenNames.split(", ")));
            }
        }
    }

    private void linkChildren() {
        children.forEach(this::linkChildren);
    }

    private void linkChildren(String programName, List<String> childrenName) {
        Program parent = programs.get(programName);
        childrenName.stream().map(programs::get).forEach(parent::attachChild);
    }

    private Program findRoot() {
        Optional<Program> root = programs.values().stream().filter(program -> !program.getParent().isPresent()).findFirst();
        return root.orElseThrow(IllegalStateException::new);
    }

}
