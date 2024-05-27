package com.prediction;

import main.java.com.prediction.Preprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Contains unit tests for the Preprocessor class to ensure that:
 * - Text data is correctly read from a file.
 * - Text is converted to lowercase.
 * - Non-alphabetic characters are removed.
 */
public class PreprocessorTest {

    public static void main(String[] args) {
        String filePath = "data/text_data.txt";
        try {
            // Preprocess the text
            String preprocessedText = Preprocessor.preprocessText(filePath);

            // Read the expected output from a separate file for comparison
            String expectedOutput = new String(Files.readAllBytes(Paths.get("data/expected_output.txt")));

            // Compare the preprocessed text with the expected output
            if (expectedOutput.trim().equals(preprocessedText.trim())) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
                System.out.println("Expected: " + expectedOutput);
                System.out.println("Got: " + preprocessedText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
