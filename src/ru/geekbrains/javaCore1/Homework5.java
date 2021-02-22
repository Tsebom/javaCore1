package ru.geekbrains.javaCore1;

/* Домашнее задание №5
 *  @author Nezhdanov Sergei
 *  @version 5.0
 * */

public class Homework5 {

    public static void main(String[] args) {
        Person[] employees = new Person[5];

        employees[0] = new Person("Leoid Makarov", "CEO", "leonid@mail.ru",
                "222332322", 300000000, 50);
        employees[1] = new Person("Dima Rozin", "Enginer", "dima@gmail.com",
                "892313313", 30000, 18);
        employees[2] = new Person("Vasia Ivan", "Engineer", "vasia@mailbox.com",
                "892312323", 30000, 30);
        employees[3] = new Person("Nadejda Makarova", "Accountant", "nadegda@mailbox.com",
                "892312312", 300000000, 45);
        employees[4] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                "892312312", 30000, 30);

        for (Person p :
                employees) {
            if (p.age > 40)
                p.printEmployee();
        }
    }
}
