package ru.acmp.task303;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();
        int[] data = new int[line.length()];
        int[] result = new int[line.length()];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        for (int i = 0; i < data.length; i++) {
            int count = 1;
            for (int j = 0; j < data.length; j++) {
                if (j != i) {
                    if ((count % 2) != 0) {
                        result[i] += data[j];
                    } else if ((count % 2) == 0) {
                        result[i] -= data[j];
                    }
                    count++;
                } else {
                    continue;
                }
            }
        }
        int maxSum = result[0];
        for (int i = 0; i < result.length; i++) {
            if (result[i] > maxSum) {
                maxSum = result[i];
            }
        }
        System.out.println(maxSum);
    }
}
