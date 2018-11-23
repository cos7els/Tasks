package ru.acmp.task557;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NOW {
    public static Scanner in;

    static {
        try {
            in = new Scanner(new File("c:/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
        String readed = "";
        StringBuilder builder = new StringBuilder();
        while (in.hasNextLine()) {
            builder.append(in.nextLine()).append(" ");
        }
        readed = builder.toString().trim();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(readed);
        int i = 0;
        while (m.find()) {
            values[i] = Integer.parseInt(m.group());
            i++;
        }
        quantityOfMatrix = values[0];
        sizeOfMatrix = values[1];
        line = values[2] - 1;
        row = values[3] - 1;
        mod = values[4];
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
                    int temp = (first[i][k] * second[k][j]) >= mod ? (first[i][k] * second[k][j]) % mod : (first[i][k] * second[k][j]);
                    result[i][j] = (result[i][j] + temp) >= mod ? (result[i][j] + temp) % mod : (result[i][j] + temp);
                }
            }
        }
        return result;
    }
}