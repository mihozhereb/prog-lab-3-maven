package org.example.environment.animals;

public class AnimalAlreadyDiedException extends Exception {
    private final Animal animal;

    public AnimalAlreadyDiedException(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String getMessage() {
        return "Животное " + animal.getName() + " уже мертво.";
    }
}
