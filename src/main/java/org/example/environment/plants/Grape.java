package org.example.environment.plants;

import org.example.counters.Counter;
import org.example.products.Storage;

public class Grape extends Plant implements Dryable, Fermentable {
    private final Counter bunchOfGrapesCounter = new Counter();

    {
        setName("Виноград");
        setColor("Темно-синий");
        setHeight((float) (Math.random() * 0.02 + 0.03));
    }

    @Override
    public void grow() {
        bunchOfGrapesCounter.add(1 + (int)(Math.random() * 10));
        setHeight((float) (getHeight() + Math.random() * 0.05));
    }

    @Override
    public void dry() {
        Storage.RAISIN.quantity.add((int) (getNumberOfBunchOfGrapes() * 0.5));
        bunchOfGrapesCounter.reset();
    }

    public int getNumberOfBunchOfGrapes() {
        return bunchOfGrapesCounter.getCounter();
    }

    @Override
    public void ferment() {
        Storage.WINE.quantity.add((int) (getNumberOfBunchOfGrapes() * 0.75));
        bunchOfGrapesCounter.reset();
    }
}
