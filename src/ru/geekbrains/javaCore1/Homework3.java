package ru.geekbrains.javaCore1;

/* Домашнее задание №3 15.02.2021
 *  @author Nezhdanov Sergei
 *  @version v1.0
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Homework3 {

    public static void main(String[] args){
        System.out.println("Exercise 1: The Game \"Guess number\"");
        guessNumber();
        System.out.println("\n" + "Exercise 2: The Game \"Guess word\"");
        guessWord();
    }

    /* 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки
    *     угадать это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
    *     чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
    *     1 – да / 0 – нет»(1 – повторить, 0 – нет).
    * */

    /**
     * The Game "Guess number"
     */
    public static void guessNumber() {
        int attempts = 3;// number of attempts
        int start = 1;// begin of game
        while (start == 1) {
            Random random = new Random();
            int number = random.nextInt(10);// the imagine number
            //System.out.println(number);// cheater
            System.out.println("Отгадай число от 0 до 9.");
            int i = 0;// number of attempt
            while (i < attempts) {
                int answer = inputNumber(0, 9, "Введите целое число от 0 до 9 включительно");
                if (answer == number) {
                    System.out.println("Верно! Вы выйграли");
                    break;
                }
                else if (answer < number) {
                    System.out.println("Загаданное число больше");
                }
                else {
                    System.out.println("Загаданное число меньше");
                }
                i++;
            }
            if (i == attempts) {
                System.out.println("Вы проиграли!");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            start = inputNumber(0, 1, "Чтобы продолжить игру необходимо" +
                    " ввести: 1 – да / 0 – нет");
        }
    }

    /**
     * Reading integer number from a set range
     * @param head - the beginning of range
     * @param tail - the ending of range
     * @param message - out of range
     * @return - integer number
     */
    public static int inputNumber(int head, int tail, String message) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number;
        while (true) {
            try {
                number = Integer.parseInt(bufferedReader.readLine());
                if (number >= head && number <= tail) {
                    break;
                }
                else {
                    System.out.println(message);
                }
            }
            // if empty or not integer
            catch (NumberFormatException | IOException e) {
                System.out.println("Необходимо ввести целое число от " + head + " до " + tail + " включительно");
            }
        }
        return number;
    }

    /* 2. Создать массив из слов
    *     String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
    *     "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
    *     "pepper", "pineapple", "pumpkin", "potato"}. При запуске программы компьютер загадывает слово, запрашивает
    *     ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
    *     Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    *     apple – загаданное
    *     apricot - ответ игрока
    *     ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    *     Угаданные в прошлые ответы буквы запоминать не надо. То есть при следующем ответе: carpet
    *     (ковер, не фрукт, но это всего лишь пример), будет выведено:
    *     ####e##########
    *
    *     Для сравнения двух слов посимвольно можно пользоваться:
    *     String str = "apple";
    *     char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    *     Играем до тех пор, пока игрок не отгадает слово.
    *     Используем только буквы в нижнем регистре.
    * */

    /**
     * The Game "Guess word"
     */
    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Character[] hideTample = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', };

        Random random = new Random();
        int indexWord = random.nextInt(words.length);// the index of the word
        String imagineWord = words[indexWord];// the imagine word
        //System.out.println(imagineWord);// cheater
        System.out.println("Отгадай загаданное слово.");
        while (true) {
            String answer = inputWord();
            if (answer.equals(imagineWord)) {
                System.out.println("Верно! Вы выйграли");
                break;
            }
            else {
                Character[] hide = hideTample.clone();
                // determine the number of iteration
                int lengthWord = Math.min(answer.length(), imagineWord.length());
                for (int i = 0; i < lengthWord; i++) {
                    if (answer.charAt(i) == imagineWord.charAt(i)) {
                        hide[i] = answer.charAt(i);
                    }
                }
                for (Character s :
                        hide) {
                    System.out.print(s);
                }
                System.out.println("\nПоробуй еще раз.");
            }
        }
    }

    /**
     * Reading word and check that it has right format
     * @return - search string
     */
    public static String inputWord() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while (true) {
            try {
                word = bufferedReader.readLine();
                break;
            }
            // if empty
            catch (NumberFormatException | IOException e) {
                System.out.println("Введите слово.");
            }
        }
        return word.toLowerCase();
    }
}
