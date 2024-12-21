package org.example.environment.plants;

import org.example.products.Storage;

public class Wheat extends Plant implements Collectable {
    {
        setName("Пшеница");
        setColor("Желтый");
        setHeight((float) (Math.random() * 0.02 + 0.03));
    }

    @Override
    public void collect() {
        Storage.WHEAT.quantity.add((int) (getHeight() * 100));
        setHeight(0.03f);
    }

    @Override
    public void grow() {
        setHeight((float) (getHeight() + Math.random() * 0.3));
    }
}
