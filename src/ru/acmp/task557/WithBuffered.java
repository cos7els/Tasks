package ru.acmp.task557;

import java.io.*;

public class WithBuffered {
    public static int quantityOfMatrix;
    public static int sizeOfMatrix;
    public static int line;
    public static int row;
    public static int mod;
    public static int[] values;

    public static void main(String[] args) {
        initialize();
        /*int[][][] matrix = buildMatrix();
        int[][] result = matrix[0];
        for (int i = 1; i < quantityOfMatrix; i++) {
            result = multipleMatrix(result, matrix[i]);
        }
        System.out.println(result[line][row]);*/
    }

    public static void initialize() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            quantityOfMatrix = in.read();
            System.out.println();
            /*sizeOfMatrix = in.read();
            System.out.println(sizeOfMatrix);
            line = in.read() - 1;
            System.out.println(line);
            row = in.read() - 1;
            System.out.println(row);
            mod = in.read();
            System.out.println(mod);
            values = new int[(sizeOfMatrix * sizeOfMatrix * quantityOfMatrix)];
            System.out.println(values.length);
            for (int i = 0; i < values.length; i++) {
                values[i] = in.read();
            }*/
        } catch (IOException e) {}
    }

    public static int[][][] buildMatrix() {
        int count = 5;
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
                    if (result[i][j] > mod) {
                        result[i][j] = result[i][j] % mod;
                    }
                }
            }
        }
        return result;
    }
}
