package ru.geekbrains.homework05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Backup {

    public static void main(String[] args) {
        createBackup("D:\\GeekBrains\\Java_Core\\Homework\\homework05\\src\\main\\java\\ru\\geekbrains\\homework05");
    }

    private static void createBackup(String source) {
        File sourceObject = new File(source);

        File destinationDirectory = new File("./backup");
        if (!destinationDirectory.exists()){
            destinationDirectory.mkdir();
        }

        File[] files = sourceObject.listFiles();
        for (File file : files) {
            try {
                File backup = new File(destinationDirectory + "/" + file.getName());
                Files.copy(file.toPath(), backup.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Backup didn't created");
                e.printStackTrace();
            }
        }
        System.out.println("Backup created.");
    }
}
