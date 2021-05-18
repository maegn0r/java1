package homework1;

public class HomeWorkApp1 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(2, 4);
        checkSumSign(-1, -3);
        printColor(10);
        printColor(109);
        printColor(0);
        compareNumbers(2, 2);
        compareNumbers(1, 3);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(int a, int b) {
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else System.out.println("Зеленый");

    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println(a + " >= " + b);
        } else System.out.println(a + " < " + b);
    }
}
