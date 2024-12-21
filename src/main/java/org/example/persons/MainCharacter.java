package org.example.persons;

import org.example.environment.Island;

import java.util.Objects;

public class MainCharacter extends Person implements Farmer {
    private int spirituality;

    public MainCharacter(String name, int spirituality) {
        super(name);

        this.spirituality = spirituality;
    }

    public void readBible() {
        action("Прилежно читает слово божие");
        spirituality += 200;
    }

    public void pray() {
        action("Провел день в молитве");
        spirituality += 100;
    }

    public int getSpirituality() {
        return spirituality;
    }

    public void saySpiritualPhrases(SpiritualPhrase ... phrases) throws NotEnoughSpiritualityException {
        for (SpiritualPhrase phrase : phrases) {
            if (spirituality < phrase.cost()) {
                throw new NotEnoughSpiritualityException();
            }

            spirituality -= phrase.cost();
            say(phrase.phrase());
        }
    }

    @Override
    public void work() {
        action("В разгаре работы");
    }

    @Override
    public String toString() {
        return "MainCharacter{" +
                "name=" + getName() +
                "spirituality=" + spirituality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainCharacter that = (MainCharacter) o;
        return spirituality == that.spirituality && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), spirituality);
    }

    public float ownershipOfIsland(Island island) {
        float islandSquare = island.getSquare();
        int numberOfPeopleOnIsland = island.getIslandPopulation().size();
        return islandSquare / numberOfPeopleOnIsland;
    }
}
