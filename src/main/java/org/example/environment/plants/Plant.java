package org.example.environment.plants;

import org.example.environment.Growable;

import java.util.Objects;

public abstract class Plant implements Growable {
    private String name;
    private String color;
    private float height;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public float getHeight() {
        return height;
    }

    void setName(String name) {
        this.name = name;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Float.compare(height, plant.height) == 0 && Objects.equals(name, plant.name) &&
                Objects.equals(color, plant.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, height);
    }
}
