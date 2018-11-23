package ru.acmp.task557;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int quantity = in.nextInt();
        int size = in.nextInt();
        int line = in.nextInt() - 1;
        int row = in.nextInt() - 1;
        int mod = in.nextInt();
        int[][] a = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int[][] b = new int[size][size];
        int[][] result = new int[size][size];
        for (int x = 1; x < quantity; x++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    b[i][j] = in.nextInt();
                }
            }
            for (int j = 0; j < size; j++) {
                result[line][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[line][j] = result[line][j] + a[line][k] * b[k][j];
                }
                if (result[line][j] > mod) {
                    result[line][j] = result[line][j] % mod;
                }
            }
            a = result;
            result = new int[size][size];
        }
        System.out.println(a[line][row]);
    }
}
