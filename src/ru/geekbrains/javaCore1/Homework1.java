package ru.geekbrains.javaCore1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Домашнее задание №1 09.02.2021
*  @author Nezhdanov Sergei
*  @version 1.0
* */

public class Homework1 {

    public static void main(String[] args) throws IOException {

	    // 2.Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte b = 127;
        short s = 32700;
        int a = 10;
        long l = 100;
        float f = 1.5f;
        double d = 2.8;
        char ch = 'a';
        boolean v = true;

        // Проверка заданий с 3 по 8
        System.out.println("Exercise 3: " + resolution(1.5f, 1.5f, 1.5f, 1.5f));
        System.out.println("");
        System.out.println("Exercise 4: " + checkRange(5, 10));
        System.out.println("");
        System.out.print("Exercise 5: ");
        checkSign1(0);
        System.out.println("");
        System.out.println("Exercise 6: " + checkSign2(-1));
        System.out.println("");
        System.out.print("Exercise 7: ");
        helloName("Сергей");
        System.out.println("");
        System.out.println("Exercise 8: Введите год для проверки или -1 для выхода из программы");
        //Бесконечная проверка пока user не введет отрицательное число
        int year = 0;
        while (year >= 0) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            year = Integer.parseInt(bufferedReader.readLine());
            if (year >= 0) {
                oddYear(year);
            }
        }
    }

    /* 3.Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     *   где a, b, c, d – аргументы этого метода, имеющие тип float.
     */
    public static float resolution(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    /* 4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма
    *     лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    */
    public static boolean checkRange(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20 ? true : false;
    }

    /* 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    *     положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    */
    public static void checkSign1(int a) {
        if (a < 0) {
            System.out.println("число отрицательное");
        }
        else {
            System.out.println("число положительное");
        }
    }

    /* 6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    *     если число отрицательное, и вернуть false если положительное.
    */
    public static boolean checkSign2(int a) {
        return a < 0 ? true : false;
    }

    /* 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен
    *     вывести в консоль сообщение «Привет, указанное_имя!».
    */
    public static void helloName(String name) {
        System.out.println("Привет, " + name);
    }

    /* 8. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    *     Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
    public static void oddYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Год " + year + " високосный");
        }
        else {
            System.out.println("Год " + year + " невисокосный");
        }
    }
}