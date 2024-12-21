package org.example.counters;

public enum MonthOfYear {
    January ("Январь"),
    February ("Февраль"),
    March ("Март"),
    April ("Апрель"),
    May ("Май"),
    June ("Июнь"),
    July ("Июль"),
    August ("Август"),
    September ("Сентябрь"),
    October ("Октябрь"),
    November ("Ноябрь"),
    December ("Декабрь");

    private final String title;

    MonthOfYear(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "MonthOfYear{" +
                "title='" + title + '\'' +
                '}';
    }
}
