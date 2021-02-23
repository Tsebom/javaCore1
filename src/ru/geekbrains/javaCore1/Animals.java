package ru.geekbrains.javaCore1;

public abstract class Animals {
    protected static int countAnimals;
    protected String name;

    Animals(String name) {
        this.name = name;
        countAnimals++;
    }

    protected abstract void run(int obstacle);

    protected abstract void swim(int obstacle);
}
