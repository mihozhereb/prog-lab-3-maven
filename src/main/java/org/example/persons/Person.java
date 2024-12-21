package org.example.persons;

import org.example.environment.animals.Animal;
import org.example.environment.animals.AnimalAlreadyDiedException;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private final String name;
    private final ArrayList<Person> friends = new ArrayList<Person>();
    private ArrayList<Person> enemies = new ArrayList<Person>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void work();

    public void kill(Animal animal) throws AnimalAlreadyDiedException {
        action("Пытается убить " + animal.getName());
        animal.die();
    };

    public void say(String phrase) {
        System.out.println(getName() + " сказал: \"" + phrase + "\"");
    }

    public void thought(String phrase) {
        System.out.println(getName() + " подумал: \"" + phrase + "\"");
    }

    public void action(String phrase) {
        System.out.println(getName() + " *" + phrase + "*");
    }

    public abstract String toString();

    public abstract int hashCode();

    public abstract boolean equals(Object obj);

    public ArrayList<Person> getFriends() {
        return friends;
    }

    public void addFriends(Person ... friends) {
        this.friends.addAll(List.of(friends));
    }

    public ArrayList<Person> getEnemies() {
        return enemies;
    }

    public void addEnemies(Person ... enemies) {
        this.enemies.addAll(List.of(enemies));
    }
}
