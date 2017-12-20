package day18.vm;

import day18.vm.Register;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Registers {

    private final Map<String, Register> registers = new HashMap<>();

    public Register get(String name) {
        return registers.computeIfAbsent(name, n -> new Register());
    }

    @Override
    public String toString() {
        return registers.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue().value())
                .collect(Collectors.joining(", "));
    }

}
