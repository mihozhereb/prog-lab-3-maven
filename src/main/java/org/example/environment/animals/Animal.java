package org.example.environment.animals;

import org.example.environment.Growable;

import java.util.Objects;

public abstract class Animal implements Growable {
    private String name;
    private float size;
    private boolean isAlive = true;

    public abstract void die() throws AnimalAlreadyDiedException;

    public boolean isAlive() {
        return isAlive;
    }

    void notAlive() {
        isAlive = false;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSize(float size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public float getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", isAlive=" + isAlive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Float.compare(size, animal.size) == 0 && isAlive == animal.isAlive && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, isAlive);
    }
}
