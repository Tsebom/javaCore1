package ru.geekbrains.javaCore1;

public class Cat extends Animals{
    private static int countCat;

    public Cat(String name) {
        super(name);
        countCat++;
    }

    public static int getCountCat() {
        return countCat;
    }

    @Override
    public void run(int obstacle) {
        if (obstacle > 200) {
            System.out.println(name + " не может преодолеть " + obstacle + "м");
            return;
        }
        System.out.println(name + " пробежит " + obstacle + "м");
    }

    @Override
    public void swim(int obstacle) {
        System.out.println("Кошки не умеют плавать, но это не точно");
    }
}
