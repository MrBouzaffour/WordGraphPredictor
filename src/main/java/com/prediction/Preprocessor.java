package com.prediction;

/**
 * Handles text preprocessing.
 * This file contains a method to read text data from a file, convert the text to lowercase,
 * and remove non-alphabetic characters.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Preprocessor {
    public static String preprocessText(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return content.toLowerCase().replaceAll("[^a-z\s]", "");
    }
}
