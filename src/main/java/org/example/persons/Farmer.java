package org.example.persons;

import org.example.environment.Island;
import org.example.environment.plants.Collectable;
import org.example.environment.plants.Dryable;
import org.example.environment.plants.Fermentable;
import org.example.environment.plants.Plant;

public interface Farmer {
    public default void collect(Collectable plant) {
        plant.collect();
    }

    public default void dry(Dryable plant) {
        plant.dry();
    }

    public default void ferment(Fermentable plant) {
        plant.ferment();
    }

    public default void sow(Island island, Plant... plants) {
        island.addFlora(plants);
    }
}
