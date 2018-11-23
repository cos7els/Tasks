package ru.acmp.task17;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean seqFound = false;
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		for (int i = 1; i < n; i++) {
			if ((n - 1) % i == 0) {
				seqFound = true;
				for (int j = i; j < n; j++) {
					if (nums[j] != nums[j - i]) {
						seqFound = false;
						break;
					}
				}
				if (seqFound) {
					System.out.println(i);
					return;
				}
			}
		}
	}
}
