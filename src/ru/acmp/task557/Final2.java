package ru.acmp.task557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Final2 {
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
        in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        levels = Integer.parseInt(s.trim().split("\\D")[0]);
        sizeOfMatrix = Integer.parseInt(s.trim().split(" ")[1]);
        s = in.readLine();
        line = Integer.parseInt(s.trim().split("\\D")[0]) - 1;
        row = Integer.parseInt(s.trim().split("\\D")[1]) - 1;
        s = in.readLine().trim();
        mod = Integer.parseInt(s);
        int[][][] data = new int[levels][sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                s = in.readLine().trim();
                if (s.equals("")) {
                    s = in.readLine().trim();
                }
                for (int k = 0; k < sizeOfMatrix; k++) {
                    data[i][j][k] = Integer.parseInt(s.split("\\D")[k]);
                }
            }
        }
        in.close();
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