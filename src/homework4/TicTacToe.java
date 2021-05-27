package homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final char EMPTY_CELL_SYM = '-';
    static final char CROSS = 'X';
    static final char ZERO = 'O';
    static final int SIZE = 5;

    public static void start() {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(field[i], EMPTY_CELL_SYM);
        }
        drawField(field);

        do {
            playerMove(field);
            drawField(field);
            if (isWin(field, CROSS)) {
                System.out.println("Поздравляем! Вы победили!!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Зафиксирована ничья!");
                break;
            }

            AIMove(field);
            drawField(field);
            if (isWin(field, ZERO)) {
                System.out.println("Вы проиграли!!!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Зафиксирована ничья!");
                break;
            }
        } while (true);

    }

    public static boolean isDraw(char[][] field) {
        for (int v = 0; v < field.length; v++) {
            for (int h = 0; h < field.length; h++) {
                if (isEmptyCell(field, v, h)) {
                    return false;

                }

            }

        }
        return true;
    }

    public static boolean isEmptyCell(char[][] field, int v, int h) {
        return field[v][h] == EMPTY_CELL_SYM;
    }

    public static boolean isNotEmptyCell(char[][] field, int v, int h) {
        return !isEmptyCell(field, v, h);
    }

    public static boolean isWin(char[][] field, char sign) {
        if (checkIsHorizontalWin(field, sign)) {
            return true;
        }
        if (checkIsVerticalWin(field, sign)) {
            return true;
        }
        if (checkIsDiagonalWin1(field, sign)) {
            return true;
        }
        if (checkIsDiagonalWin2(field, sign)) {
            return true;
        }
        return false;

    }

    private static boolean checkIsDiagonalWin1(char[][] field, char sign) {

        for (int i = 0; i < SIZE; i++) {
            if (field[i][i] != sign) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIsDiagonalWin2(char[][] field, char sign) {

        for (int i = 0; i < SIZE; i++) {
            if (field[i][SIZE - 1 - i] != sign) {
                    return false;
                }
            }
        return true;
    }

    public static boolean checkIsHorizontalWin(char[][] field, char sign) {
        for (int i = 0; i < SIZE; i++) {
            int r = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == sign) {
                    r++;
                }
            }
            if (r == SIZE) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIsVerticalWin(char[][] field, char sign) {
        for (int j = 0; j < SIZE; j++) {
            int r = 0;
            for (int i = 0; i < SIZE; i++) {
                if (field[i][j] == sign) {
                    r++;
                }
            }
            if (r == SIZE) {
                return true;
            }
        }
        return false;
    }

    public static void AIMove(char[][] field) {
        Random random = new Random();
        int v, h;
        do {
            v = random.nextInt(3);
            h = random.nextInt(3);
        } while (isNotEmptyCell(field, v, h));
        field[v][h] = 'O';
    }

    public static void playerMove(char[][] field) {
        int v, h;
        do {
            v = getCoordinate(field, 'v');
            h = getCoordinate(field, 'h');
        } while (isNotEmptyCell(field, v, h));
        field[v][h] = 'X';
    }


    public static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getCoordinate(char[][] field, char coordinateName) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;
        do {
            System.out.printf("Пожалуйста введите %s-координату [1...%d] ...%n", coordinateName, SIZE);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= field.length);
        return coordinate;

    }
}
