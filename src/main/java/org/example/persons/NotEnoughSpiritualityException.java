package org.example.persons;

public class NotEnoughSpiritualityException extends Exception {
    public NotEnoughSpiritualityException(String message) {
        super(message);
    }

    public NotEnoughSpiritualityException() { }

    @Override
    public String getMessage() {
        return "Недостаточно духовности, чтобы сказать фразу.";
    }
}
