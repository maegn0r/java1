package homework4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final char empty_cell_sym = '-';

    public static void start() {
        char[][] field = {
                {empty_cell_sym, empty_cell_sym, empty_cell_sym},
                {empty_cell_sym, empty_cell_sym, empty_cell_sym},
                {empty_cell_sym, empty_cell_sym, empty_cell_sym}
        };
        drawField(field);

        do {
            playerMove(field);
            drawField(field);
            if (isWin(field, 'X')) {
                System.out.println("Поздравляем! Вы победили!!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Зафиксирована ничья!");
                break;
            }

            AIMove(field);
            drawField(field);
            if (isWin(field, 'O')) {
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
        return field[v][h] == empty_cell_sym;
    }

    public static boolean isNotEmptyCell(char[][] field, int v, int h) {
        return !isEmptyCell(field, v, h);
    }

    public static boolean isWin(char[][] field, char sign) {
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign) {
                return true;
            }
        }
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) {
                return true;
            }
        }
            if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) {
                return true;
            }
            if (field[0][2] == sign && field[1][1] == sign && field[2][0] == sign) {
                return true;
            }
         return false;
    }

        public static void AIMove ( char[][] field){
            Random random = new Random();
            int v, h;
            do {
                v = random.nextInt(3);
                h = random.nextInt(3);
            } while (isNotEmptyCell(field, v, h));
            field[v][h] = 'O';
        }

        public static void playerMove ( char[][] field){
            int v, h;
            do {
                v = getCoordinate(field, 'v');
                h = getCoordinate(field, 'h');
            } while (isNotEmptyCell(field, v, h));
            field[v][h] = 'X';
        }


        public static void drawField ( char[][] field){
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    System.out.print(field[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static int getCoordinate ( char[][] field, char coordinateName){
            Scanner scanner = new Scanner(System.in);
            int coordinate;
            do {
                System.out.printf("Пожалуйста введите %s-координату [1...3] ...%n", coordinateName);
                coordinate = scanner.nextInt() - 1;
            } while (coordinate < 0 || coordinate >= field.length);
            return coordinate;

        }
    }
