package ru.acmp.task118;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt() - 1;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() != 1) {
            count += k;
            while (count >= list.size()) {
                count = count >= list.size() ? count - list.size() : count;
            }
            list.remove(count);
        }
        int result = list.get(0) + 1;
        System.out.println(result);
    }
}