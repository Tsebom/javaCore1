package ru.geekbrains.javaCore1;

public class Person {
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployee() {
        String space = "          ";
        System.out.println("Employee: " +
                "name - " + name + '\n' + space +
                "position - " + position + '\n' + space +
                "email - " + email + '\n' + space +
                "phone - " + phone + '\n' + space +
                "salary - " + salary + '\n' + space +
                "age - " + age);
    }
}
