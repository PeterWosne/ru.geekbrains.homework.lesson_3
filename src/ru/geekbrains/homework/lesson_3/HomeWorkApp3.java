package ru.geekbrains.homework.lesson_3;

import java.util.Arrays;

public class HomeWorkApp3 {

    public static void main(String[] args) {
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

          int[] intArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

          for(int i = 0;i < intArray.length;i++) {
              if(intArray[i] == 0)
                  intArray[i] = 1;
              else
                  intArray[i] = 0;
          }

          System.out.println(Arrays.toString(intArray));

//        2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
//        значениями 1 2 3 4 5 6 7 8 … 100;

        int[] intArray2 = new int[100];
        for (int i = 0; i < intArray2.length; i++) {
            intArray2[i] = i + 1;
        }
        System.out.println(Arrays.toString(intArray2));

//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа
//        меньшие 6 умножить на 2;

        int[] intArray3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < intArray3.length; i++) {
            if(intArray3[i] < 6)
                intArray3[i] *= 2;
        }
        System.out.println(Arrays.toString(intArray3));

//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
//        цикла(-ов) заполнить его диагональные элементы единицами...

        int[][] twoDimArray = new int[5][5];
        for(int i = 0,k = twoDimArray.length - 1;i < twoDimArray.length;i++, k--) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                twoDimArray[i][i] = 1;
                twoDimArray[i][k] = 1;
                System.out.print(twoDimArray[i][j] + "\t");
            }
            System.out.println("");
        }

        // или немного не по заданию, не с интовым массивом, но поинтереснее выглядит
        printAndrewFlag(7, "1");

//        5. Пятую пропускаем как было сказано на занятии

//        6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

        int[] arr = {10,9,8,7,7,14, 6, 5, 4,-13,3,2,1,0};
        findMinAndMax(arr);

//        7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//        если в массиве есть место, в котором сумма левой и правой части массива равны.

        int[] array = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("Есть ли в массиве " + Arrays.toString(array) +
                " место, в котором сумма левой и правой части массива равны? "
                + checkBalance(array));

//        8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//        или отрицательным),при этом метод должен сместить все элементы массива на n позиций.
//        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
//        [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].

        System.out.println(Arrays.toString(shift(new int[]{3, 5, 6, 1},-2)));
    }

    public static void printAndrewFlag(int num, String symbol) {
        String[][] array = new String[num][num];
        for(int i = 0;i < array.length;i++) {
            Arrays.fill(array[i], " ");
        }

        for(int i = 0,k = array.length - 1;i < array.length;i++, k--) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][i] = symbol;
                array[i][k] = symbol;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void findMinAndMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0;i < array.length;i++) {
            if(array[i] > max)
                max = array[i];
            if(array[i] < min)
                min = array[i];
        }
        System.out.println("Минимальное число в массиве: " + min);
        System.out.println("Максимальное число в массиве: " + max);
    }

    public static boolean checkBalance(int[] array) {
        int left = array[0];
        int right = 0;
        for(int i = 1;i < array.length;i++) {
            right += array[i];
        }

        for(int i = 0;i < array.length - 1;i++) {
            if(left == right) {
                return true;
            }else {
                left += array[i + 1];
                right -= array[i + 1];
            }
        }

        return false;
    }

    public static int[] shift(int[] arr, int n) {
        if(n >= 0) {
            for (int j = 0; j < n; j++) {
                int buffer = arr[0];
                arr[0] = arr[arr.length - 1];
                for (int i = 1; i < arr.length - 1; i++) {
                    arr[arr.length - i] = arr[arr.length - 1 - i];
                }
                arr[1] = buffer;
            }
        }else {
            n = Math.abs(n);
            for (int j = 0; j < n; j++) {
                int buffer = arr[0];
                for(int i = 0;i < arr.length - 1;i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = buffer;
            }
        }

        return arr;
    }
}
