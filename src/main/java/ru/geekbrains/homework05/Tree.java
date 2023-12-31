package ru.geekbrains.homework05;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * Метод для распечатки директорий и файлов
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        for (int i = 0; i < files.length; i++) {
            print(files[i], indent, i == files.length - 1);
        }
    }
}
