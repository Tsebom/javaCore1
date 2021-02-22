package ru.geekbrains.javaCore1;

/*  Домашнее задание №1
 *  @author Nezhdanov Sergei
 *  @version 1.0
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *  The game of tic tac toe
 */
public class Homework4 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static String[][] map;
    private static final int SIZE_MAP = 5;
    private static final int DOT_WIN = 4;
    private static final String DOT_EMPTY = ".";
    private static final String DOT_X = "X";
    private static final String DOT_O = "O";

    private static final int setGame = 1;//the games were played
    private static final Map<String, Integer> statGame= new HashMap<>();

    public static void main(String[] args) {
        statGame.put("Партий сыграно: ", 0);
        statGame.put("Ваших побед: ", 0);
        statGame.put("Побед у AI_1: ", 0);
        statGame.put("Побед у AI_2: ", 0);
        statGame.put("Сыграно в ничью: ", 0);

        do {
            initMap();
            printMap();
            statGame.replace("Партий сыграно: ", statGame.get("Партий сыграно: ") + 1);
            do {
                //person's block
                personTurn(DOT_X);
                if (winGame(DOT_X)) {
                    statGame.replace("Ваших побед: ", statGame.get("Ваших побед: ") + 1);
                    break;
                }
                if (drawGame()) break;

                //AI_1's block
                aiTurn(DOT_O, DOT_X);
                printMap();
                if (winGame(DOT_O)) {
                    statGame.replace("Побед у AI_1: ", statGame.get("Побед у AI_1: ") + 1);
                    break;
                }
                if (drawGame()) break;

                //AI_2's block
//                aiTurn(DOT_X, DOT_O);
//                printMap();
//                if (winGame(DOT_X)) {
//                    statGame.replace("Побед у AI_2: ", statGame.get("Побед у AI_2: ") + 1);
//                    break;
//                }
//                if (drawGame()) break;
            }
            while (true);

        }
        while (statGame.get("Партий сыграно: ") != setGame);

        scanner.close();

        System.out.println("Партий сыграно: " + statGame.get("Партий сыграно: "));
        System.out.println("Ваших побед: " + statGame.get("Ваших побед: "));
        System.out.println("Побед у AI_1: " + statGame.get("Побед у AI_1: "));
//        System.out.println("Побед у AI_2: " + statGame.get("Побед у AI_2: "));
        System.out.println("Сыграно в ничью: " + statGame.get("Сыграно в ничью: "));

    }

    /**
     *  Prepare a field for a game
     */
    public static void initMap() {
        map = new String[SIZE_MAP][SIZE_MAP];
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     *  Print a field of the game
     */
    public static void printMap() {
        //print the first line
        System.out.print("  ");
        for (int i = 0; i < SIZE_MAP; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println("X");
        // print the other line
        for (int i = 0; i < SIZE_MAP; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE_MAP; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Y");
    }

    /**
     * Player turn
     * @param symbol - a Player's chip
     */
    public static void personTurn(String symbol) {
        String[] coordinate;//storage coordinates
        outer:
        do {
            System.out.print("Введите координаты в формате \"X Y\": ");
            String line = scanner.nextLine().trim();
            //first checking of correct input
            if (line.contains(" ")) {
               coordinate = line.split(" ", 2);
            }
            else {
                continue;
            }
            //checking for integer
            for (int i = 0; i < coordinate.length; i++) {
                coordinate[i]= coordinate[i].trim();
                for (char ch : coordinate[i].toCharArray()) {
                    if ((int)ch < 49 || (int)ch > 57) continue outer;
                    }
            }
            //second checking of correct input
            if (Integer.parseInt(coordinate[0]) > 0 && Integer.parseInt(coordinate[0]) <= SIZE_MAP &&
                    Integer.parseInt(coordinate[1]) > 0 && Integer.parseInt(coordinate[1]) <= SIZE_MAP) {
                if (checkCell(Integer.parseInt(coordinate[1]) - 1, Integer.parseInt(coordinate[0]) - 1)){
                    map[Integer.parseInt(coordinate[1]) - 1][Integer.parseInt(coordinate[0]) - 1] = symbol;
                    break;
                }
                System.out.println("Данная позиция занята!");
            }
        }
        while (true);
    }

    /**
     * AI turn
     * @param symbol - an AI's chip
     * @param enemySymbol - an enemy chip
     */
    public static void aiTurn(String symbol, String enemySymbol) {
        int x, y;
        //checking enemy's win
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (checkCell(i, j)) {
                    map[i][j] = enemySymbol;
                    if (winGame(enemySymbol)) {
                        map[i][j] = symbol;
                        return;
                    }
                    else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        //checking our win
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (checkCell(i, j)) {
                    map[i][j] = symbol;
                    if (winGame(symbol)) {
                        map[i][j] = symbol;
                        return;
                    }
                    else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        do {
            x = random.nextInt(SIZE_MAP);
            y = random.nextInt(SIZE_MAP);
        }
        while (!checkCell(x, y));
        map[x][y] = symbol;
    }

    /**
     * Checking cells for empty
     * @param x - horizontal coordinate
     * @param y - vertical coordinate
     * @return - if empty then true but if occupied then false
     */
    public static boolean checkCell(int x, int y) {
        return map[x][y].equals(DOT_EMPTY);
    }

    /**
     * Checking if there was a victory
     * @param symbol - a checkable chip
     * @return - if victory then true but if lose then false
     */
    public static boolean winGame(String symbol) {
        //checking horizontals
        for (int i = 0; i < SIZE_MAP; i++) {
            int quantitySymbol = 0;
            for (int j = 0; j < SIZE_MAP; j++) {
                if (!map[i][j].equals(symbol) && j > SIZE_MAP - DOT_WIN - 1) {
                    break;
                }else if (map[i][j].equals(symbol)) {
                    quantitySymbol++;
                    if (quantitySymbol == DOT_WIN) {
                        return true;
                    }
                }
                else {
                    quantitySymbol = 0;
                }
            }
        }

        //checking verticals
        for (int i = 0; i < SIZE_MAP; i++) {
            int quantitySymbol = 0;
            for (int j = 0; j < SIZE_MAP; j++) {
                if (!map[j][i].equals(symbol) && j > SIZE_MAP - DOT_WIN - 1) {
                    break;
                }else if (map[j][i].equals(symbol)) {
                    quantitySymbol++;
                    if (quantitySymbol == DOT_WIN) return true;
                }
                else {
                    quantitySymbol = 0;
                }
            }
        }

        //checking left diagonal
        int quantitySymbol = 0;
        for (int i = 0; i < SIZE_MAP; i++) {

            if (!map[i][i].equals(symbol) && i > SIZE_MAP - DOT_WIN - 1) {
                break;
            }else if (map[i][i].equals(symbol)) {
                quantitySymbol++;
                if (quantitySymbol == DOT_WIN) return true;
            }
            else {
                quantitySymbol = 0;
            }
        }

        //checking right diagonal
        quantitySymbol = 0;
        for (int i = 0; i < SIZE_MAP; i++) {
            if (!map[i][SIZE_MAP - 1 - i].equals(symbol) && i > SIZE_MAP - DOT_WIN - 1) {
                break;
            }else if (map[i][SIZE_MAP - 1 - i].equals(symbol)) {
                quantitySymbol++;
                if (quantitySymbol == DOT_WIN) return true;
            }
            else {
                quantitySymbol = 0;
            }
        }

        return false;
    }

    /**
     * Checking if there was a draw
     * @return - if draw then true but if not then false
     */
    public static boolean drawGame() {
        for (int i = 0; i < SIZE_MAP; i++) {
            for (int j = 0; j < SIZE_MAP; j++) {
                if (map[i][j].equals(DOT_EMPTY)) return false;
            }
        }
        statGame.replace("Сыграно в ничью: ", statGame.get("Сыграно в ничью: ") + 1);
        return true;
    }
}
