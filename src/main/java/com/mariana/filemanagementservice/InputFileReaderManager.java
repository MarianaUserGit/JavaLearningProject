package com.mariana.filemanagementservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputFileReaderManager {

    public static void readDataFromATextFile(File file) {
        try {
            System.out.println(Files.readString(Path.of(file.getPath())));
        } catch (IOException exceptionObject) {
            System.out.println("There is an exception " + exceptionObject.getMessage());
        }
    }

    public static void readDataFromATextFileUsingFileReader(File file) {
        try {
            FileReader fileReader = new FileReader(file);

            int charIntValue = 0;

            while ((charIntValue = fileReader.read()) != -1) {
                System.out.print((char) charIntValue);
            }
        } catch (IOException exception) {
            System.out.println("There is an exception: " + exception.getMessage());
        }
    }

    public static void readDataFromATextFileUsingBufferedReader(File inputFile) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFile));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("The file was not found " + e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
