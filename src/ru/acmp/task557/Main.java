package ru.acmp.task557;

import java.util.Scanner;

public class Main {
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
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                    if (result[i][j] >= mod) {
                        result[i][j] = result[i][j] % mod;
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    a[i][j] = result[i][j];
                    result[i][j] = 0;
                }
            }
        }
        System.out.println(a[line][row]);
    }
}
