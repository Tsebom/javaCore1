package ru.geekbrains.javaCore1;

public class Plate {
    private final int FOOD_SIZE;// the size of a plate
    private int food;// quantity of food

    public Plate(int food) {
        this.FOOD_SIZE = food;
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(Cat cat) {
        if (cat.getAppetite() > food) {
            System.out.println(cat.getName() + " поел " + food + " и просит еще");
            cat.setAppetite(cat.getAppetite() - food);
            food = 0;
        }
        else {
            food -= cat.getAppetite();
            cat.setFull(true);
            cat.setAppetite(0);
        }
    }

    public void increaseFood() {
        System.out.println("Добавили в тарелку " + (FOOD_SIZE - food));
        food += (FOOD_SIZE - food);

    }

    public void info() {
        System.out.println("В тарелке " + food);
    }
}
