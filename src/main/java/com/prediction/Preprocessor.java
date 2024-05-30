package com.prediction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;

/**
 * Handles text preprocessing.
 * This file contains a method to read text data from a file, convert the text to lowercase,
 * and remove non-alphabetic characters.
 */
public class Preprocessor {
    /**
     * Reads text data from a file, converts it to lowercase, and removes non-alphabetic characters.
     *
     * @param filePath the path to the text file
     * @return a list of preprocessed words
     * @throws IOException if an I/O error occurs reading from the file
     */
    public static List<String> preprocessText(String filePath) throws IOException {
        // Read the content of the file into a string
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        // Convert the text to lowercase
        content = content.toLowerCase();

        // Remove non-alphabetic characters and split into words
        String[] words = content.replaceAll("[^a-z\\s]", "").split("\\s+");

        return Arrays.asList(words);
    }

}
