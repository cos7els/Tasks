package ru.acmp.task557;

import java.io.PrintWriter;
import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int quantityOfMatrix = in.nextInt();
        int sizeOfMatrix = in.nextInt();
        int line = in.nextInt() - 1;
        int row = in.nextInt() - 1;
        int mod = in.nextInt();
        int readedMatrix = 0;

        int[][] result = new int[sizeOfMatrix][sizeOfMatrix];
        int[][] first = new int[sizeOfMatrix][sizeOfMatrix];
        int[][] second = new int[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                first[i][j] = in.nextInt();
            }
        }
        readedMatrix++;

        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                second[i][j] = in.nextInt();
            }
        }
        readedMatrix++;

        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                for (int k = 0; k < sizeOfMatrix; k++) {
                    int mult = (first[i][k] * second[k][j]) >= mod ? (first[i][k] * second[k][j]) % mod : first[i][k] * second[k][j];
                    result[i][j] = (result[i][j] + mult) >= mod ? (result[i][j] + mult) % mod : result[i][j] + mult;
                }
            }
        }

        while (readedMatrix < quantityOfMatrix) {
            first = result;
            result = new int[sizeOfMatrix][sizeOfMatrix];

            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    second[i][j] = in.nextInt();
                }
            }
            readedMatrix++;

            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    for (int k = 0; k < sizeOfMatrix; k++) {
                        int mult = (first[i][k] * second[k][j]) >= mod ? (first[i][k] * second[k][j]) % mod : first[i][k] * second[k][j];
                        result[i][j] = (result[i][j] + mult) >= mod ? (result[i][j] + mult) % mod : result[i][j] + mult;
                    }
                }
            }
        }
        out.print(result[line][row]);
        out.flush();
    }
}
