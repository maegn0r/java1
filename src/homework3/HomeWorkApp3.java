package homework3;

import java.util.Random;

public class HomeWorkApp3 {

    public static void main(String[] args) {
        printArray(binArray());
        printArray(hundredArr());
        printArray(multipleTask());
        printArray(squareArr(5));
        printArray(newArr(5, 3));
        int[] arr = {1, 5, 3, -2, 11, 4, 5, 2, 4, 8, 9, 0};
        minMaxArr(arr);
        int[] forSumArr = {1, 2, 2, 1};
        int[] forSumArr2 = {1, 2, 1, 1, 5};
        System.out.println(sumArr(forSumArr2));
        printArray(shiftArray(arr, -2));

        int[] testArray = fillArrayRandomly(50);
        printArray(testArray);
        minMaxArr(testArray);
        printArray(getArray1(5));
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
// Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static int[] binArray() {
        int[] bin = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < bin.length; i++) {
            if (bin[i] == 1) {
                bin[i] = 0;
            } else bin[i] = 1;
        }
        return bin;
    }

    // 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static int[] hundredArr() {
        int[] arr = new int[100];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = k + 1;
        }
        return arr;
    }

    //    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static int[] multipleTask() {
        int[] bin = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < bin.length; i++) {
            if (bin[i] < 6) {
                bin[i] = bin[i] * 2;
            }
        }
        return bin;
    }


    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    // заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной
    // из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static int[][] squareArr(int size) {
        int[][] square = new int[size][size];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if ((i == j) || (i + j == size - 1)) {
                    square[i][j] = 1;
                }
            }
        }
        return square;

    }

    //5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
    // типа int длиной len, каждая ячейка которого равна initialValue;
    public static int[] newArr(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    public static void minMaxArr(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(min + " - это минимальное значение в данном массиве\n" + max + " - это максимальное значение в данном массиве");
    }

    // 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    //**Примеры:
    //checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
    //checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
    //
    //граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
    public static boolean sumArr(int[] arr) {
        if (arr.length < 2) return false;
        for (int i = 1; i <= arr.length - 1; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft = sumLeft + arr[j];
            }
            for (int g = i; g < arr.length; g++) {
                sumRight = sumRight + arr[g];
            }
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    //8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
    // задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    public static int[] shiftArray(int[] arr, int a) {
        if (a >= 0) {
            int shift = a % arr.length;
            for (int j = 0; j < shift; j++) {
                int buffer = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    arr[i - 1] = arr[i];
                    if (i == arr.length - 1) {
                        arr[i] = buffer;
                    }
                }
            }
        } else {
            int shift = a % arr.length;
            for (int j = 0; j > shift; j--) {
                int buffer = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                    if (i == 1) {
                        arr[i - 1] = buffer;
                    }
                }
            }
        }
        return arr;
    }

    // Перегруженный метод для печати в консоль массивов
    public static void printArray(int[] printedArray) {
        for (int i = 0; i < printedArray.length; i++) {
            if (i == printedArray.length - 1) {
                System.out.println(printedArray[i]);
            } else System.out.print(printedArray[i] + " ");
        }
    }

    public static void printArray(int[][] printedArray) {
        for (int i = 0; i < printedArray.length; i++) {
            for (int j = 0; j < printedArray[i].length; j++) {
                if (j == printedArray[i].length - 1) {
                    System.out.println(printedArray[i][j]);
                } else System.out.print(printedArray[i][j] + " ");
            }
        }
    }

    // Мини домашнее задание, о котором ты говорил на уроке 3 (довести до ума метод,
    // возвращающий массив заполненный рандомными числами от -5 до 5)
    static int[] fillArrayRandomly(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generateRandom(-5, 5);
        }
        return numbers;
    }

    static int generateRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int[][] getArray1(int size) {
        int[][] arr = new int[size][];
        for (int i = 1; i <= size; i++) {
                arr[i-1] = new int[i];
            }
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = arr[i].length - j;
            }
        }

        return arr;
    }
}