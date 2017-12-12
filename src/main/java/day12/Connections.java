package day12;

import common.Stack;

import java.util.*;
import java.util.stream.Collectors;

public class Connections {

    private final Map<Integer, List<Integer>> neighbours = new HashMap<>();

    public void add(int origin, int... neighbours) {
        this.neighbours.put(origin, Arrays.stream(neighbours).boxed().collect(Collectors.toList()));
    }

    public Collection<Integer> resolve(int origin) {

        Stack<Integer> unvisited = new Stack<>();
        Set<Integer> connected = new HashSet<>();

        unvisited.push(origin);

        while (!unvisited.isEmpty()) {
            Integer current = unvisited.pop();
            connected.add(current);

            List<Integer> currentNeighbours = neighbours.get(current);
            currentNeighbours.stream()
                .filter(neighbour -> !connected.contains(neighbour))
                .forEach(unvisited::push);
        }

        return connected;
    }

}
