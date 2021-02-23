package ru.geekbrains.javaCore1;

public class Dog extends Animals{
    private static int countDog;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    public static int getCountDog() {
        return countDog;
    }

    @Override
    public void run(int obstacle) {
        if (obstacle > 500) {
            System.out.println(name + " не может преодолеть " + obstacle + "м");
            return;
        }
        System.out.println(name + " пробежит " + obstacle + "м");
    }

    @Override
    public void swim(int obstacle) {
        if (obstacle > 10) {
            System.out.println(name + " не может проплыть " + obstacle + "м");
            return;
        }
        System.out.println(name + " проплывет " + obstacle + "м");
    }
}
