package ru.acmp.task557;

import java.util.Scanner;

public class FinalFinal2 {
    public static Scanner in = new Scanner(System.in);
    public static int quantityOfMatrix = in.nextInt();
    public static int sizeOfMatrix = in.nextInt();
    public static int line = in.nextInt() - 1;
    public static int row = in.nextInt() - 1;
    public static int mod = in.nextInt();
    public static int[] values;
    static {
        values = new int[(sizeOfMatrix * sizeOfMatrix * quantityOfMatrix)];
        for (int i = 0; i < values.length; i++) {
            values[i] = in.nextInt();
        }
        in.close();
    }
    public static void main(String[] args) {
        int[][][] matrix = buildMatrix();
        int[][] result = matrix[0];
        for (int i = 1; i < quantityOfMatrix; i++) {
            result = multipleMatrix(result, matrix[i]);
        }
        System.out.println(result[line][row]);
    }
    public static int[][][] buildMatrix() {
        int count = 0;
        int[][][] matrix = new int[quantityOfMatrix][sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < quantityOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++, count++) {
                    matrix[i][j][k] = values[count];
                }
            }
        }
        return matrix;
    }
    public static int[][] multipleMatrix(int[][] first, int[][] second) {
        int[][] result = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
                if (result[i][j] > mod) {
                    result[i][j] = result[i][j] % mod;
                }
            }
        }
        return result;
    }
}