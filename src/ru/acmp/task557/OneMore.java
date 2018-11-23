package ru.acmp.task557;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OneMore {
    public static BufferedReader in;
    public static int levels;
    public static int sizeOfMatrix;
    public static int line;
    public static int row;
    public static int mod;

    public static void main(String[] args) throws IOException {
        int[][][] data = initialize();
        int[][] result = data[0];
        for (int i = 1; i < levels; i++) {
            result = multipleMatrix(result, data[i]);
        }
        System.out.println(result[line][row]);
    }

    private static int[][][] initialize() throws IOException {
        in = new BufferedReader(new FileReader("c:/input.txt"));
        StringBuilder resultString = new StringBuilder();
        String readString;
        while ((readString = in.readLine()) != null) {
            resultString.append(readString).append(" ");
        }
        String[] stringArr = resultString.toString().trim().split(" ");
        levels = Integer.parseInt(stringArr[0]);
        sizeOfMatrix = Integer.parseInt(stringArr[1]);
        line = Integer.parseInt(stringArr[2]) - 1;
        row = Integer.parseInt(stringArr[3]) - 1;
        mod = Integer.parseInt(stringArr[4]);
        int[][][] data = new int[levels][sizeOfMatrix][sizeOfMatrix];
        int m = 6;
        for ( ; m < stringArr.length; ) {
            for (int i = 0; i < levels; i++) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    for (int k = 0; k < sizeOfMatrix; k++) {
                        data[i][j][k] = Integer.parseInt(stringArr[m]);
                        m++;
                    }
                }
                m++;
            }
        }
        return data;
    }

    private static int[][] multipleMatrix(int[][] first, int[][] second) {
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