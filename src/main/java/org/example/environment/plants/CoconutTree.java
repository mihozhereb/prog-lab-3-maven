package org.example.environment.plants;

import org.example.counters.Counter;
import org.example.products.Storage;

public class CoconutTree extends Plant implements Collectable {
    private final Counter coconutCounter = new Counter();

    {
        setName("Кокосовая пальма");
        setColor("Зеленый");
        setHeight((float) (Math.random() * 0.1 + 0.1));
    }

    @Override
    public void grow() {
        coconutCounter.add(1 + (int)(Math.random() * 3));
        setHeight((float) (getHeight() + Math.random() * 0.25));
    }

    public int getNumberOfCoconuts() {
        return coconutCounter.getCounter();
    }

    @Override
    public void collect() {
        Storage.COCONUT.quantity.add(getNumberOfCoconuts());
        coconutCounter.reset();
    }
}
