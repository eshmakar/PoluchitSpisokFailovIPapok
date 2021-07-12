package com.test;

import java.io.*;
import java.nio.file.*;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    private static void printVlozhennyePapkiIFaily() throws IOException {
        //если не сможет прочитать - вываливается
        try (Stream<Path> paths = Files.walk(Paths.get("C:/"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }
    }

    private static void printDirectoriesAndFiles() throws IOException {
        //        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("C:/"), "*.{txt,sys}");// "*.{txt}" - можно указать для вывода только по определнным расширениям. "*.{txt,sys}" - можно указать несколько расшерении БЕЗ ПРОБЕЛА
        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("C:/"));
        for (Path x : paths)
            System.out.println(x);
        paths.close();
    }

    private static void printDirectoriesOnly() throws IOException {
        //ВЫВОДИТЬ ТОЛЬКО ПАПКИ
        DirectoryStream.Filter<Path> papki = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };

        DirectoryStream<Path> onlyDirectories = Files.newDirectoryStream(Paths.get("C:/"), papki);
        for (Path p : onlyDirectories)
            System.out.println(p);
        onlyDirectories.close();
    }

    private static void printFilesOnly() throws IOException {
        //ВЫВОДИТЬ ТОЛЬКО ФАЙЛЫ
        File folder = new File("C:/");

        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (!fileEntry.isDirectory()) {
                System.out.println(fileEntry.getName());
            }
        }
    }


    public static void main(String[] args) throws IOException {
//        printDirectoriesAndFiles();//ВЫВОДИТЬ СПИСОК ПАПОК И ФАЙЛОВ
//        printDirectoriesOnly();//ВЫВОДИТЬ ТОЛЬКО ПАПКИ
        printFilesOnly();//ВЫВОДИТЬ ТОЛЬКО ФАЙЛЫ

    }
}
