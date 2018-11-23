package ru.acmp.task557;

import java.util.Scanner;

public class Final {
    public static Scanner in;
    public static int levels;
    public static int sizeOfMatrix;
    public static int line;
    public static int row;
    public static int mod;

    public static void main(String[] args) {
        int[][][] data = initialize();
        int[][] result = data[0];
        for (int i = 1; i < levels; i++) {
            result = multipleMatrix(result, data[i]);
        }
        System.out.println(result[line][row]);
    }

    public static int[][][] initialize() {
        in = new Scanner(System.in);
        levels = in.nextInt();
        sizeOfMatrix = in.nextInt();
        line = in.nextInt() - 1;
        row = in.nextInt() - 1;
        mod = in.nextInt();
        int[][][] data = new int[levels][sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    data[i][j][k] = in.nextInt();
                }
            }
        }
        in.close();
        return data;
    }

    public static int[][] multipleMatrix(int[][] first, int[][] second) {
        int[][] result = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    int temp = (first[i][k] * second[k][j]) >= mod ? (first[i][k] * second[k][j]) % mod : (first[i][k] * second[k][j]);
                    result[i][j] = (result[i][j] + temp) >= mod ? (result[i][j] + temp) % mod : (result[i][j] + temp);
                }
            }
        }
        return result;
    }
}