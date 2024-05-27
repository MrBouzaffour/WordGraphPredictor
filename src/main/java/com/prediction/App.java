package com.prediction;

import main.java.com.prediction.Graph.Graph;
import main.java.com.prediction.Preprocessor;
import main.java.com.prediction.Predictor;

import java.io.IOException;
import java.util.Scanner;

/**
 * The main entry point of the application.
 * This file loads and preprocesses the text data, builds the graph of character transitions,
 * provides a command-line interface for user interaction, and takes user input to predict the next character.
 */
public class App {
    public static void main(String[] args) {
        // Path to the text data file
        String filePath = "data/text_data.txt";

        try {
            // Preprocess the text data
            String preprocessedText = Preprocessor.preprocessText(filePath);

            // Create a graph and build it from the preprocessed text
            Graph<Character> graph = new Graph<>();
            for (int i = 0; i < preprocessedText.length() - 1; i++) {
                char currentChar = preprocessedText.charAt(i);
                char nextChar = preprocessedText.charAt(i + 1);
                graph.addEdge(currentChar, nextChar, 1); // Using weight 1 for simplicity
            }

            // Initialize the predictor with the built graph
            Predictor predictor = new Predictor(graph);

            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Command-line interface for user interaction
            System.out.println("Character Prediction System");
            System.out.println("Type a character to predict the next character, or type 'exit' to quit.");

            while (true) {
                System.out.print("Enter a character: ");
                String input = scanner.nextLine();

                // Exit the loop if the user types "exit"
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Validate input
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Please enter a single alphabetic character.");
                    continue;
                }

                // Predict the next character
                char currentChar = input.charAt(0);
                Character predictedChar = predictor.predictNextChar(currentChar);

                // Display the prediction
                if (predictedChar != null) {
                    System.out.println("The predicted next character after '" + currentChar + "' is: " + predictedChar);
                } else {
                    System.out.println("No prediction can be made for the character: " + currentChar);
                }
            }

            // Close the scanner
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
