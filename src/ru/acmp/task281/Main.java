package ru.acmp.task281;

import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        long result = 0;
        for (int i = m; i <= n; i++) {
            if (i == n) {
                result += 1;
            } else {
                result += factorial(n) / (factorial(n - i) * factorial(i));
            }
        }
        System.out.println(result);
    }
    public static long factorial(long n) {
        long result;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        result = factorial(n - 1) * n;
        return result;
    }
}
