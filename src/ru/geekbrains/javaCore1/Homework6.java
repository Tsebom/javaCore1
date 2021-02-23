package ru.geekbrains.javaCore1;

/* Домашнее задание №6
 *  @author Nezhdanov Sergei
 *  @version 1.0
 * */

public class Homework6 {

    public static void main(String[] args) {
        //create 4 dogs
        Dog dogBobik = new Dog("Бобик");
        Dog dogBelka = new Dog("Белка");
        Dog dogStrelka = new Dog("Стреклка");
        Dog dogSharik = new Dog("Шарик");

        //create 3 cats
        Cat catMurka = new Cat("Мурка");
        Cat catNurka = new Cat("Нюрка");
        Cat catBoris = new Cat("Борис");

        System.out.println("Всего животных - " + Animals.countAnimals);
        System.out.println("Собак - " + Dog.getCountDog());
        System.out.println("Котов - " + Cat.getCountCat());

        dogBobik.run(200);
        dogBelka.run(600);
        dogStrelka.swim(5);
        dogSharik.swim(20);

        catMurka.run(150);
        catNurka.run(300);
        catBoris.swim(10);
    }
}
