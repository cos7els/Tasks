package ru.acmp.task579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int count = 1;
        int positiveSum = 0;
        int positiveCount = 0;
        String positivePositions = new String();
        int negativeSum = 0;
        int negativeCount = 0;
        String negativePositions = new String();
        while (count <= length) {
            int data = in.nextInt();
            if (data >= 0) {
                positiveSum += data;
                positiveCount++;
                positivePositions += count + " ";
            } else if (data < 0) {
                negativeSum += data;
                negativeCount++;
                negativePositions += count + " ";
            }
            count++;
        }
        if (positiveSum > (negativeSum * - 1)) {
            System.out.println(positiveCount);
            System.out.print(positivePositions.trim());
        } else if (positiveSum < (negativeSum * - 1)) {
            System.out.println(negativeCount);
            System.out.print(negativePositions.trim());
        } else if (positiveSum == (negativeSum * - 1)) {
            System.out.println(positiveCount);
            System.out.print(positivePositions.trim());
        }
    }
}
