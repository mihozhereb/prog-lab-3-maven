package org.example.products;

import org.example.counters.Counter;

public enum Storage {
    WINE ("Вино"),
    RAISIN ("Изюм"),
    TurtleMeat ("Мясо черепахи"),
    COCONUT ("Кокос"),
    WHEAT ("Пшеница");

    private final String title;
    public final Counter quantity;

    Storage(String title) {
        this.title = title;
        this.quantity = new Counter();
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity.getCounter();
    }

    @Override
    public String toString() {
        return "Storage{" +
                "title='" + title + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
