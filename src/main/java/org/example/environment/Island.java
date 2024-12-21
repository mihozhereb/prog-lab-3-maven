package org.example.environment;

import org.example.environment.animals.Animal;
import org.example.environment.plants.Grape;
import org.example.environment.plants.Plant;
import org.example.persons.Person;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Island extends Place {

    private final ArrayList<Animal> fauna = new ArrayList<Animal>();
    private final ArrayList<Plant> flora = new ArrayList<Plant>();
    private final ArrayList<Person> islandPopulation = new ArrayList<Person>();

    public Island(String title, float x, float y, Class<?> ... environment) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super(title, x, y);

        for (Class<?> newObjectClass : environment) {
            int b = (int) (Math.random() * 100);

            for (int i = 0; i < b; i++) {
                Object a = newObjectClass.getDeclaredConstructor().newInstance();
                if (a instanceof Plant) {
                    addFlora((Plant) a);
                } else if (a instanceof Animal) {
                    addFauna((Animal) a);
                }
            }
        }
    }

    public void addFauna(Animal ... animals) {
        fauna.addAll(List.of(animals));
    }

    public void addFlora(Plant ... plants) {
        flora.addAll(List.of(plants));
    }

    public void addPersons(Person ... persons) {
        islandPopulation.addAll(List.of(persons));
    }

    public ArrayList<Animal> getFauna() {return fauna;}

    public ArrayList<Plant> getFlora() {return flora;}

    public ArrayList<Person> getIslandPopulation() {return islandPopulation;}

    @Override
    public String toString() {
        return "Island{" +
                "title='" + getTitle() + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", fauna=" + fauna +
                ", flora=" + flora +
                ", islandPopulation=" + islandPopulation +
                '}';
    }
}
