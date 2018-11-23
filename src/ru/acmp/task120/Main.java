package ru.acmp.task120;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] nums = new int[n][m];
		int[][] costs = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				nums[i][j] = in.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0) {
					if (j == 0) {
						costs[i][j] = nums[i][j];
					} else {
						costs[i][j] = costs[i][j - 1] + nums[i][j];
					}
				} else {
					if (j == 0) {
						costs[i][j] = costs[i - 1][j] + nums[i][j];
					} else {
						costs[i][j] = (costs[i - 1][j] + nums[i][j]) < (costs[i][j - 1] + nums[i][j]) ?
								(costs[i - 1][j] + nums[i][j]) : (costs[i][j - 1] + nums[i][j]);
					}
				}

			}
		}
		System.out.println(costs[n - 1][m - 1]);
	}
}
