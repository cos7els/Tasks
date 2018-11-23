package ru.acmp.task2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long sum = 1;
		if (n < 0) {
			for (int i = 0; i >= n; i--) {
				sum = sum + i;
			}
		} else if (n == 0) {
			sum = 1;
		} else {
			sum = (1 + n) * n / 2;
		}
		System.out.println(sum);
	}
}