package com.test;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class VyvoditVsehDirectoriiNaFail {
    private static final Path path = Paths.get("D:/");//путь к папке

    public static class Visitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            System.out.println(file);//вывод списка файлов
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println(dir);//вывод списка папок
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        //ВЫВОД ВСЕХ ДИРЕКТОРИИ НА ФАЙЛ
        System.setOut(new PrintStream("C:/treeWithVideo.txt"));
        Files.walkFileTree(path, new Visitor());

    }
}
