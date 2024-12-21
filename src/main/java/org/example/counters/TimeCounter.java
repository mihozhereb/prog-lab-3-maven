package org.example.counters;

import org.example.environment.Growable;
import org.example.environment.Island;
import org.example.environment.animals.Animal;
import org.example.environment.plants.Plant;

public class TimeCounter extends Counter {
    public TimeCounter(int c) {
        super(c);
    }

    private DayOfWeek GetDayOfWeek() {
        return switch (this.c % 7) {
            case 0 -> DayOfWeek.MONDAY;
            case 1 -> DayOfWeek.TUESDAY;
            case 2 -> DayOfWeek.WEDNESDAY;
            case 3 -> DayOfWeek.THURSDAY;
            case 4 -> DayOfWeek.FRIDAY;
            case 5 -> DayOfWeek.SATURDAY;
            case 6 -> DayOfWeek.SUNDAY;
            default -> throw new RuntimeException("DayOfWeek runtime error");
        };
    }

    private MonthOfYear GetMonth() {
        int a = this.c % 365;

        if (a < 31) {
            return MonthOfYear.January;
        } else if (a < 59) {
            return MonthOfYear.February;
        } else if (a < 90) {
            return MonthOfYear.March;
        } else if (a < 120) {
            return MonthOfYear.April;
        } else if (a < 151) {
            return MonthOfYear.May;
        } else if (a < 181) {
            return MonthOfYear.June;
        } else if (a < 212) {
            return MonthOfYear.July;
        } else if (a < 243) {
            return MonthOfYear.August;
        } else if (a < 273) {
            return MonthOfYear.September;
        } else if (a < 304) {
            return MonthOfYear.October;
        } else if (a < 334) {
            return MonthOfYear.November;
        } else {
            return MonthOfYear.December;
        }
    }

    private int GetDayOfMonth() {
        int a = this.c % 365;

        if (a < 31) {
            return a + 1;
        } else if (a < 59) {
            return a - 31 + 1;
        } else if (a < 90) {
            return a - 59 + 1;
        } else if (a < 120) {
            return a - 90 + 1;
        } else if (a < 151) {
            return a - 120 + 1;
        } else if (a < 181) {
            return a - 151 + 1;
        } else if (a < 212) {
            return a - 181 + 1;
        } else if (a < 243) {
            return a - 212 + 1;
        } else if (a < 273) {
            return a - 243 + 1;
        } else if (a < 304) {
            return a - 273 + 1;
        } else if (a < 334) {
            return a - 304 + 1;
        } else {
            return a - 334 + 1;
        }
    }

    public void GetNow() {
        System.out.println("Сегодня " + this.GetDayOfWeek().getTitle() + ", " + this.GetDayOfMonth() + " " +
                this.GetMonth().getTitle() + " " + this.c / 365 + " года" + "\nВсего " + this.c + " дней");
        if (this.c % 365 == 0) {
            System.out.println(this.c / 365 + " годовщина!");
        }
    }

    public void NextDayOnIsland(Island island) {
        this.add(1);

        for (Plant plant : island.getFlora()) {
            if (plant instanceof Growable) {
                plant.grow();
            }
        }

        for (Animal animal : island.getFauna()) {
            if (animal instanceof Growable) {
                animal.grow();
            }
        }
    }
}
