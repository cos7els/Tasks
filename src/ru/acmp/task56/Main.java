package ru.acmp.task56;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<String> friends = new TreeSet<>();
        TreeSet<String> users = new TreeSet<>();
        int quantityOfFriends = in.nextInt();
        if (quantityOfFriends >= 0 && quantityOfFriends <= 200) {
            for (int i = 0; i <= quantityOfFriends; i++) {
                friends.add(in.nextLine());
            }
        }
        int quantityOfUsers = in.nextInt();
        if (quantityOfUsers >= 0 && quantityOfUsers <= 200) {
            for (int i = 0; i <= quantityOfUsers; i++) {
                users.add(in.nextLine());
            }
        }
        String friendsResult = friends.toString().length() > 2 ? friends.toString().substring(3, friends.toString().length() - 1) : "";
        String mutualResult = "";
        String alsoResult = "";
        for (String s : users) {
            if (friends.contains(s)) {
                mutualResult += s + ", ";
            } else {
                alsoResult += s + ", ";
            }
        }
        mutualResult = mutualResult.length() > 2 ? mutualResult.substring(2, mutualResult.length() - 2) : "";
        alsoResult = alsoResult.length() > 0 ? alsoResult.substring(0, alsoResult.length() - 2) : "";
        System.out.print("Friends: " + friendsResult + "\n" +
                "Mutual Friends: " + mutualResult + "\n" +
                "Also Friend of: " + alsoResult);
    }
}