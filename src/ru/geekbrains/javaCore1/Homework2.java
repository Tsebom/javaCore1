package ru.geekbrains.javaCore1;

/* Домашнее задание №2 12.02.2021
 *  @author Nezhdanov Sergei
 *  @version 1.0
 * */

import java.util.Arrays;

public class Homework2 {

    public static void main(String[] args) {
        System.out.println("Exercise 1: ");
        exercise1();
        System.out.println("");
        System.out.println("Exercise 2: ");
        exercise2();
        System.out.println("");
        System.out.println("Exercise 3: ");
        exercise3();
        System.out.println("");
        System.out.println("Exercise 4: ");
        exercise4();
        System.out.println("");
        System.out.println("Exercise 5: ");
        exercise5();
        System.out.println("");
        System.out.println("Exercise 6: ");
        System.out.println(isEqualParts(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(isEqualParts(new int[]{1, 1, 1, 2, 1}));
        System.out.println(isEqualParts(new int[]{1, 1, 1, 2, 10}));
        System.out.println("");
        System.out.println("Exercise 7: ");
        move(new int[]{1, 2, 3}, 1);
        move(new int[]{1, 2, 3}, 7);
        move(new int[]{3, 5, 6, 1}, -2);
        move(new int[]{3, 5, 6, 1}, -10);
        System.out.println("");
    }

    /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    *     С помощью цикла и условия заменить 0 на 1, 1 на 0
    * */
    public static void exercise1() {
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            }
            else {
                array[i]= 0;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /* 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
    * */
    public static void exercise2() {
        int[] array = new int[8];
        int value = 0;
        for (int i = 0; i < 8; i ++) {
            array[i] = value;
            value += 3;
        }

        System.out.println(Arrays.toString(array));
    }

    /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2
    * */
    public static void exercise3() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    *     и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    *     если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких
    *     элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]
    * */
    public static void exercise4() {
        int[][] array = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == i || i + j == 10 -1) {
                    array[i][j] = 1;
                }
                else {
                    array[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /* 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
    * */
    public static void exercise5() {
        int[] array = new int[]{3, 1, 2, 5, 4, 6, 7, 9, 8};
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            else if (array[i] > max){
                max = array[i];
            }
        }
        System.out.println("Max: " + max  + "\n" + "Min: " + min);
    }

    /* 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    *     если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
    *     checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    *     граница показана символами ||, эти символы в массив не входят
    * */
    public static boolean isEqualParts(int[] array) {
        if (array.length > 1) {
            int left = array[0];//the left part
            for (int i = 1; i < array.length; i++) {
                int right = 0;//the right part
                for (int j = i; j < array.length; j++)
                    right += array[j];
                if (left == right) {
                    return true;
                }
                left += array[i];
            }
        }
        return false;
    }

    /* 7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    *     или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    *     Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    *     Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
    *     при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами
    * */
    public static void move(int[] array, int n) {
        System.out.print(Arrays.toString(array) + " -> ");
        int k = Math.abs(n);//number of offsets
        //this condition  makes less number of offsets
        if (array.length < Math.abs(n)) {
            k = Math.abs(n) % array.length;
        }
        int bf;// a buffer variable
        for (int i = 0; i < k; i++) {
            if (n > 0) {
                bf = array[0];
                for (int j = 1; j < array.length; j++)
                    array[j - 1] = array[j];
                array[array.length - 1] = bf;
            }
            else {
                bf = array[array.length - 1];
                for (int j = array.length - 2; j >= 0; j--)
                    array[j + 1] = array[j];
                array[0] = bf;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
