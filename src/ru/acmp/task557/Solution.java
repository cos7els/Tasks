package ru.acmp.task557;

import java.util.Scanner;

public class Solution {
    public static Scanner in;
    public static int quantityOfMatrix;
    public static int sizeOfMatrix;
    public static int line;
    public static int row;
    public static int mod;
    public static int readedMatrix;
    public static void main(String[] args) {
        initialValues();
        int[][] result = multipleMatrix(initialMatrix(), initialMatrix());
        while (readedMatrix < quantityOfMatrix) {
            result = multipleMatrix(result, initialMatrix());
        }
        System.out.println(result[line][row]);
    }
    public static void initialValues() {
        in = new Scanner(System.in);
        quantityOfMatrix = in.nextInt();
        sizeOfMatrix = in.nextInt();
        line = in.nextInt() - 1;
        row = in.nextInt() - 1;
        mod = in.nextInt();
        readedMatrix = 0;
    }
    public static int[][] initialMatrix() {
        int[][] data = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                data[i][j] = in.nextInt();
            }
        }
        readedMatrix++;
        return data;
    }
    public static int[][] multipleMatrix(int[][] first, int[][] second) {
        int[][] result = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                    if (result[i][j] >= mod) {
                        result[i][j] = result[i][j] % mod;
                    }
                }
            }
        }
        return result;
    }
}
