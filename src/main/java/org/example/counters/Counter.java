package org.example.counters;

public class Counter {
    int c = 0;

    public Counter(int c) {
        this.c = c;
    }

    public Counter() {
        this.c = 0;
    }

    public void add(int a) {
        this.c += a;
    }

    public void decrease(int a) {
        this.c -= a;
    }

    public void reset() {
        this.c = 0;
    }

    public int getCounter() {
        return this.c;
    }

    @Override
    public String toString() {
        return "Counter{counter=" + c + "}";
    }
}
