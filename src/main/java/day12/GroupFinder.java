package day12;

import java.util.Collection;
import java.util.Set;

class GroupFinder {


    private final Connections connections;

    GroupFinder(Connections connections) {
        this.connections = connections;
    }


    public int count() {
        Set<Integer> population = connections.population();

        int groupCount = 0;
        int populationSize = population.size();
        for (int currentPerson = 0; currentPerson < populationSize; ++currentPerson) {
            if (population.contains(currentPerson)) {
                Collection<Integer> neighbours = connections.resolve(currentPerson);
                groupCount++;
                population.removeAll(neighbours);
            }
        }
        return groupCount;
    }

}
