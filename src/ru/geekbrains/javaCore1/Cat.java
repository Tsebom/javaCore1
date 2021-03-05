package ru.geekbrains.javaCore1;

public class Cat {
    private final String name;
    private int appetite;
    private boolean full;//true if cat is full or false if cat hungry

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        if (appetite >= 0) {
            this.appetite = appetite;
        }
        else {
            System.out.println(name + " тошнит от Вашей стряпни");// LOL
        }
    }

    public boolean isFull() {
        return !full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(this);
    }
}
