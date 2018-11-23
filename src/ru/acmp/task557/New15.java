package ru.acmp.task557;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class New15 {
    public static int quantityOfMatrix;
    public static int sizeOfMatrix;
    public static int line;
    public static int row;
    public static int mod;
    public static int[] values;

    public static void main(String[] args) {
        initialize();
        int[][][] matrix = buildMatrix();
        int[][] result = matrix[0];
        for (int i = 1; i < quantityOfMatrix; i++) {
            result = multipleMatrix(result, matrix[i]);
        }
        System.out.println(result[line][row]);
    }

    public static void initialize() {
        try (BufferedReader in = new BufferedReader(new FileReader("c:/input.txt"))) {
            String readed = "";
            StringBuilder builder = new StringBuilder();
            while ((readed = in.readLine()) != null) {
                if (readed.equals("/n")) continue;
                builder.append(readed).append(" ");
            }
            readed = builder.toString().trim();
            String[] data = readed.trim().split("\\D");
            quantityOfMatrix = Integer.parseInt(data[0]);
            sizeOfMatrix = Integer.parseInt(data[1]);
            line = Integer.parseInt(data[2]) - 1;
            row = Integer.parseInt(data[3]) - 1;
            mod = Integer.parseInt(data[4]);
            values = new int[(sizeOfMatrix * sizeOfMatrix * quantityOfMatrix)];
            for (int i = 0, j = 5; i < values.length; i++, j++) {
                if (data[j].equals("")) {j++;}
                values[i] = Integer.parseInt(data[j]);
            }
        } catch (IOException e) {}
    }

    public static int[][][] buildMatrix() {
        int[][][] matrix = new int[quantityOfMatrix][sizeOfMatrix][sizeOfMatrix];
        int m = 0;
        for (int i = 0; i < quantityOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++, m++) {
                    matrix[i][j][k] = values[m];
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
                    int temp = (first[i][k] * second[k][j]) >= mod ? (first[i][k] * second[k][j]) % mod : (first[i][k] * second[k][j]);
                    result[i][j] = (result[i][j] + temp) >= mod ? (result[i][j] + temp) % mod : (result[i][j] + temp);
                }
            }
        }
        return result;
    }
}