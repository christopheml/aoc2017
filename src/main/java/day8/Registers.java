package day8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Registers {

    private final Map<String, Register> registers;

    private final Function<String, Register> registerSupplier;

    Registers() {
        this(Register::new);
    }

    Registers(Function<String, Register> registerSupplier) {
        registers = new HashMap<>();
        this.registerSupplier = registerSupplier;
    }

    Register forName(String name) {
        return registers.computeIfAbsent(name, registerSupplier);
    }

    Stream<Register> stream() {
        return registers.values().stream();
    }

    Register highest() {
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
