package homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final char EMPTY_CELL_SYM = '-';
    static final char CROSS = 'X';
    static final char ZERO = 'O';
    static final int SIZE = 5;
    static int[][] priorityTable = new int[SIZE][SIZE];
    static char[][] field = new char[SIZE][SIZE];
    static boolean isHard;

    public static void start() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(field[i], EMPTY_CELL_SYM);
        }
        getHardMode();
        drawField();

        do {
            playerMove();
            drawField();
            if (isWin(CROSS)) {
                System.out.println("Поздравляем! Вы победили!!");
                break;
            }
            if (isDraw()) {
                System.out.println("Зафиксирована ничья!");
                break;
            }

            if (!isHard) {
                AIMove();
            } else
                cleverAIMove();

            drawField();
            if (isWin(ZERO)) {
                System.out.println("Вы проиграли!!!");
                break;
            }
            if (isDraw()) {
                System.out.println("Зафиксирована ничья!");
                break;
            }
        } while (true);
    }

    public static void cleanUpPriorityTable() {
        for (int i = 0; i < priorityTable.length; i++) {
            for (int j = 0; j < priorityTable.length; j++) {
                priorityTable[i][j] = 0;
            }
        }
    }

    public static boolean isDraw() {
        for (int v = 0; v < field.length; v++) {
            for (int h = 0; h < field.length; h++) {
                if (isEmptyCell(v, h)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmptyCell(int v, int h) {
        return field[v][h] == EMPTY_CELL_SYM;
    }

    public static boolean isNotEmptyCell(int v, int h) {
        return !isEmptyCell(v, h);
    }

    public static boolean isCross(int v, int h) {
        return field[v][h] == CROSS;
    }

    public static boolean isZero(int v, int h) {
        return field[v][h] == ZERO;
    }

    public static boolean isWin(char sign) {
        if (checkIsHorizontalWin(sign)) {
            return true;
        }
        if (checkIsVerticalWin(sign)) {
            return true;
        }
        if (checkIsDiagonalWin1(sign)) {
            return true;
        }
        if (checkIsDiagonalWin2(sign)) {
            return true;
        }
        return false;
    }

    private static boolean checkIsDiagonalWin1(char sign) {

        for (int i = 0; i < SIZE; i++) {
            if (field[i][i] != sign) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIsDiagonalWin2(char sign) {

        for (int i = 0; i < SIZE; i++) {
            if (field[i][SIZE - 1 - i] != sign) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIsHorizontalWin(char sign) {
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

    public static boolean checkIsVerticalWin(char sign) {
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

    public static void AIMove() {
        Random random = new Random();
        int v, h;
        do {
            v = random.nextInt(SIZE);
            h = random.nextInt(SIZE);
        } while (isNotEmptyCell(v, h));
        field[v][h] = 'O';
    }

    public static void cleverAIMove() {
        cleanUpPriorityTable();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isNotEmptyCell(i, j)) {
                    priorityTable[i][j] = -1;
                    continue;
                }
                checkNeighborhood(i, j);
            }
        }
        doAIMove();
    }

    private static void doAIMove() {
        int max = 0;
        int hMax = -1;
        int vMax = -1;
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if (priorityTable[v][h] >= max) {
                    max = priorityTable[v][h];
                    vMax = v;
                    hMax = h;
                }
            }
        }
        field[vMax][hMax] = ZERO;
    }

    private static void checkNeighborhood(int v, int h) {
        if (checkOutOfBound(v - 1, h - 1)) {
            if (isCross(v - 1, h - 1)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v - 2, h - 2) && isCross(v - 2, h - 2)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v - 1, h - 1)) {
                priorityTable[v][h] += 5;
            }
        }
        if (checkOutOfBound(v - 1, h)) {
            if (isCross(v - 1, h)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v - 2, h) && isCross(v - 2, h)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v - 1, h)) {
                priorityTable[v][h] += 5;
            }
        }
        if (checkOutOfBound(v - 1, h + 1)) {
            if (isCross(v - 1, h + 1)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v - 2, h + 2) && isCross(v - 2, h + 2)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v - 1, h + 1)) {
                priorityTable[v][h] += 5;
            }
        }
        if (checkOutOfBound(v, h - 1)) {
            if (isCross(v, h - 1)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v, h - 2) && isCross(v, h - 2)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v, h - 1)) {
                priorityTable[v][h] += 5;
            }
        }
        if (checkOutOfBound(v, h + 1)) {
            if (isCross(v, h + 1)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v, h + 2) && isCross(v, h + 2)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v, h + 1)) {
                priorityTable[v][h] += 5;
            }
        }
        if (checkOutOfBound(v + 1, h - 1)) {
            if (isCross(v + 1, h - 1)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v + 2, h - 2) && isCross(v + 2, h - 2)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v + 1, h - 1)) {
                priorityTable[v][h] += 5;
            }
        }
        if (checkOutOfBound(v + 1, h)) {
            if (isCross(v + 1, h)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v + 2, h) && isCross(v + 2, h)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v + 1, h)) {
                priorityTable[v][h] += 5;
            }
        }
        if (checkOutOfBound(v + 1, h + 1)) {
            if (isCross(v + 1, h + 1)) {
                priorityTable[v][h] += 10;
                if (checkOutOfBound(v + 2, h + 2) && isCross(v + 2, h + 2)) {
                    priorityTable[v][h] += 30;
                }
            }
            if (isZero(v + 1, h + 1)) {
                priorityTable[v][h] += 5;
            }
        }
    }

    public static boolean checkOutOfBound(int v, int h) {
        return (v >= 0 && h >= 0 && v < SIZE && h < SIZE);
    }

    public static void playerMove() {
        int v, h;
        do {
            v = getCoordinate('v');
            h = getCoordinate('h');
        } while (isNotEmptyCell(v, h));
        field[v][h] = 'X';
    }

    public static void drawField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getCoordinate(char coordinateName) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;
        do {
            System.out.printf("Пожалуйста введите %s-координату [1...%d] ...%n", coordinateName, SIZE);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= SIZE);
        return coordinate;
    }

    public static void getHardMode() {
        Scanner scanner = new Scanner(System.in);
        int mode;
        do {
            System.out.println("Добрый день. Игра \"Крестики-Нолики\" началась. Пожалуйста, выберите уровень сложности: \"0\" - легко, \"1\" - сложно");
            mode = scanner.nextInt();
        } while (mode < 0 || mode > 1);
        isHard = (mode == 1);
    }
}