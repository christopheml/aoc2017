package day8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Registers {

    private final Map<String, Register> registers;

    public Registers() {
        registers = new HashMap<>();
    }

    public Register forName(String name) {
        return registers.computeIfAbsent(name, Register::new);
    }

    public Register highest() {
        return registers.values().stream()
                .max(Comparator.comparing(Register::value))
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public String toString() {
        return registers.entrySet().stream()
                .sorted(Comparator.comparing(Entry::getKey))
                .map(entry -> entry.getValue().toString())
                .collect(Collectors.joining(", "));
    }

}
