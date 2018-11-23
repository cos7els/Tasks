package ru.acmp.task270;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();
        String result = "";
        CharSequence c = new String("_");
        CharSequence cc = new String("__");
        CharSequence space = new String(" ");
        if ((line.contains(c) && !line.toLowerCase().equals(line)) || line.startsWith("_") || line.endsWith("_") ||
                line.length() <= 0 || line.length() > 100 || line.contains(space) ||
                Character.isUpperCase(line.charAt(0)) || !line.matches("^[a-zA-Z_]+$") || line.contains(cc)) {
            System.out.print("Error!");
        } else if (!line.toLowerCase().equals(line)) {
            char[] data = line.toCharArray();
            for (int i = 0; i < data.length; i++) {
                result += Character.isUpperCase(data[i]) ? "_" + Character.toString(Character.toLowerCase(data[i])) : Character.toString(data[i]);
            }

        } else if (line.contains(c)) {
            result += line.substring(0, line.indexOf("_"));
            String[] data = line.split("_");
            for (int i = 1; i < data.length; i++) {
                result += Character.toString(Character.toUpperCase(data[i].charAt(0))).concat(data[i].substring(1));
            }
        } else {
            result = line;
        }
        System.out.print(result);
    }
}
