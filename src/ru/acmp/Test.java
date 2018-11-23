package ru.acmp;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        Files.walkFileTree(Paths.get("d:/downloads"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                list.add(file.toString());
                return super.visitFile(file, attrs);
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
        Path myFile = Paths.get("c:/input.txt");
        Path copyOfMyFile = Paths.get(myFile.getParent().toString(), "/newFile.txt");
        Path newDir = Paths.get(copyOfMyFile.getParent().toString() + "/OOO");
        boolean exist = Files.exists(copyOfMyFile);
        if (exist == false) {
            Files.copy(myFile, copyOfMyFile);
        }
        System.out.println(Files.readAllLines(myFile));
        System.out.println(Files.readAllLines(copyOfMyFile));
    }
}