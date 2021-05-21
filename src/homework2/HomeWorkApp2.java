package homework2;

public class HomeWorkApp2 {
    public static void main(String[] args) {

        System.out.println(compareNumbers(2, 10));
        System.out.println(compareNumbers(2, 3));

        isPositiveInteger(3);
        isPositiveInteger(-4);

        System.out.println(isNegativeInteger(-1));
        System.out.println(isNegativeInteger(166));

        printIt("Привет, Максим! :)", 4);

        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2100));
        System.out.println(isLeapYear(1986));
        System.out.println(isLeapYear(1988));

    }

    //1. Метод, принимающий на вход два целых числа и проверяющий,
    //что их сумма лежит в пределах от 10 до 20 (включительно), если да – возвращает true, в противном случае – false.
    public static boolean compareNumbers(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    //2. Метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    //положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void isPositiveInteger(int val) {
        if (val < 0) {
            System.out.println(val + " — это отрицательное число!");
        } else System.out.println(val + " — это положительное число!");
    }

    //3. Метод, которому в качестве параметра передается целое число. Метод должен вернуть
    //true, если число отрицательное, и вернуть false если положительное. Про ноль в условии ничего нет,
    //допустим он как и в пункте 2 считается положительным.
    public static boolean isNegativeInteger(int num) {
        return num < 0;
    }

    //4. Метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
    public static void printIt(String text, int quantity) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(text);
        }
    }

    //5. Метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean isLeapYear(int year) {
        return year % 100 != 0 && year % 4 == 0 || year % 400 == 0;
    }
}
