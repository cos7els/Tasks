package ru.acmp.task557;

import java.io.*;

public class SomeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        String lineS = in.readLine().trim();
        int quantityOfMatrix = Integer.parseInt(lineS.split(" ")[0]);
        int sizeOfMatrix = Integer.parseInt(lineS.split(" ")[1]);
        lineS = in.readLine().trim();
        int line = Integer.parseInt(lineS.split(" ")[0]) - 1;
        int row = Integer.parseInt(lineS.split(" ")[1]) - 1;
        int mod = Integer.parseInt(in.readLine().trim());
        int readedMatrix = 0;
        int[][] result = new int[sizeOfMatrix][sizeOfMatrix];
        int[][] first = new int[sizeOfMatrix][sizeOfMatrix];
        int[][] second = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            lineS = in.readLine().trim();
            for (int j = 0; j < sizeOfMatrix; j++) {
                first[i][j] = Integer.parseInt(lineS.split(" ")[j]);
            }
        }
        readedMatrix++;
        for (int i = 0; i < sizeOfMatrix; i++) {
            lineS = in.readLine().trim();
            for (int j = 0; j < sizeOfMatrix; j++) {
                second[i][j] = Integer.parseInt(lineS.split(" ")[j]);
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
                lineS = in.readLine().trim();
                for (int j = 0; j < sizeOfMatrix; j++) {
                    second[i][j] = Integer.parseInt(lineS.split(" ")[j]);
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
        out.write(result[line][row]);
        out.flush();
    }
}
