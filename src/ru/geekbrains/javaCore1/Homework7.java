package ru.geekbrains.javaCore1;

/* Домашнее задание №7
 *  @author Nezhdanov Sergei
 *  @version 1.0
 * */

public class Homework7 {

    public static void main(String[] args) {
        Cat[] cat = new Cat[4];
        Plate plate = new Plate(20);

        cat[0] = new Cat("Vaska", 10);
        cat[1] = new Cat("Borka", 30);
        cat[2] = new Cat("Murka", 5);
        cat[3] = new Cat("Obzhora", 55);

        for (Cat i : cat) {
            System.out.println("Очередь " + i.getName());
            if (plate.getFood() == 0)
                plate.increaseFood();

            plate.info();

            while (i.isFull()) {
                i.eat(plate);
                if (i.isFull())
                    plate.increaseFood();
            }
            System.out.println(i.getName() + " аппетит "  + i.getAppetite() + ", в тарелке осталось " + plate.getFood() + "\n");
        }

        System.out.print(plate.getFood() + " в урну");
    }
}