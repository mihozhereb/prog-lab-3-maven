package org.example;

import org.example.counters.Counter;
import org.example.counters.TimeCounter;
import org.example.environment.Island;
import org.example.environment.animals.Animal;
import org.example.environment.animals.AnimalAlreadyDiedException;
import org.example.environment.animals.Turtle;
import org.example.environment.plants.*;
import org.example.persons.MainCharacter;
import org.example.persons.NotEnoughSpiritualityException;
import org.example.persons.SpiritualPhrase;
import org.example.products.Storage;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        MainCharacter mainCharacter = new MainCharacter("Робинзон Крузо", 300);
        Island island;
        try {
            island = new Island("Остров Робинзона", (float) (Math.random() * 50), (float) (Math.random() * 50), Turtle.class, Grape.class, CoconutTree.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        island.addPersons(mainCharacter);

        TimeCounter currentTime = new TimeCounter(1459);

        currentTime.GetNow();

        mainCharacter.work();

        currentTime.NextDayOnIsland(island);

        currentTime.GetNow();

        mainCharacter.pray();

        if (mainCharacter.getSpirituality() > 200) {
            mainCharacter.thought("Спокойный дух сегодня");
        } else {
            mainCharacter.thought("Мой дух беспокоен сегодня");
        }

        mainCharacter.readBible();

        if (mainCharacter.getSpirituality() > 300) {
            mainCharacter.say("Я стал видеть вещи в совсем новом свете!");
        } else {
            mainCharacter.thought("Мир потух для меня");
        }

        try {
            mainCharacter.saySpiritualPhrases(
                    new SpiritualPhrase("Все мои понятия изменились, мир казался мне теперь далеким и чуждым", 100),
                    new SpiritualPhrase("Он не возбуждал во мне никаких надежд, никаких желаний", 100),
                    new SpiritualPhrase("Словом, мне нечего было делать там, и я был разлучен с ним" +
                            ", повидимому, навсегда", 100),
                    new SpiritualPhrase("Я смотрел на него такими глазами, какими, вероятно, мы смотрим на него " +
                            "с того света, т. е. как на место, где я жил когда то, но откуда ушел навсегда", 100),
                    new SpiritualPhrase("Я мог бы сказать миру теперь, как Авраам богачу: \"Между мной и тобой " +
                            "утверждена великая пропасть\"", 100),
                    new SpiritualPhrase("В самом деле, я ушел от всякой мирской скверны; у меня не было ни плотских " +
                            "искушений, ни соблазна очей, ни гордости жизни", 100)
            );
        } catch (NotEnoughSpiritualityException e) {
            mainCharacter.thought("Хватит на сегодня умных слов...");
        }

        mainCharacter.thought("Мне нечего было желать, потому что я имел все, чем мог наслаждаться");

        float cruzoOwnership = mainCharacter.ownershipOfIsland(island);

        if (cruzoOwnership < 500) {
            mainCharacter.thought("Я был господином моего острова");
        } else if (cruzoOwnership < 1500) {
            mainCharacter.thought("Я был королем всей страны, которой я владел");
        } else {
            mainCharacter.thought("Я был императором всей страны, которой я владел");
        }

        // friends or not
        if (mainCharacter.getEnemies().isEmpty()) {
            mainCharacter.thought("У меня не было соперников, не было конкурентов, никто не оспаривал моей " +
                    "власти, я ни с кем ее не делил");
        } else {
            mainCharacter.thought("У меня были соперники и конкуренты");
        }

        mainCharacter.thought("Я мог бы нагрузить целые корабли, но мне это было не нужно");

        mainCharacter.sow(island, new Wheat(), new Wheat(), new Wheat());

        mainCharacter.say("Я сеял ровно столько, чтобы хватило для меня");

        Counter turtleCounter = new Counter();
        for (Animal animal : island.getFauna()) {
            if (animal instanceof Turtle) {
                turtleCounter.add(1);
            }
        }

        if (turtleCounter.getCounter() > 50) {
            mainCharacter.say("У меня было множество черепах");
        } else {
            mainCharacter.say("У меня было не так уж и много черепах");
        }

        Animal targetAnimal = island.getFauna().get((int) (Math.random() * island.getFauna().size()));

        // exception naming
        try {
            mainCharacter.kill(targetAnimal);
            mainCharacter.say("Я довольствовался тем, что изредка убивал по одной " + targetAnimal.getName());
        } catch (AnimalAlreadyDiedException e) {
            mainCharacter.thought("Какой ужас. " + e.getMessage());
        }

        Counter treeCounter = new Counter();
        for (Plant plant : island.getFlora()) {
            if (plant instanceof CoconutTree) {
                treeCounter.add(1);
            }
        }

        if (treeCounter.getCounter() > 30) {
            mainCharacter.say("У меня было столько лесу, что я мог построить целый флот");
        } else {
            mainCharacter.say("У меня было не так уж и много леса");
        }

        for (Plant plant : island.getFlora()) {
            if (plant instanceof Dryable && plant instanceof Fermentable) {
                if (Math.random() > 0.5) {
                    mainCharacter.dry((Dryable) plant);
                } else {
                    mainCharacter.ferment((Fermentable) plant);
                }
            } else if (plant instanceof Collectable) {
                mainCharacter.collect((Collectable) plant);
            }
        }

        if (Storage.WINE.getQuantity() > 5 && Storage.RAISIN.getQuantity() > 5) {
            mainCharacter.thought("У меня было столько винограду, что все корабли моего флота можно было бы " +
                    "нагрузить вином и изюмом");
        } else {
            mainCharacter.thought("У меня было немного винограда");
        }
    }
}