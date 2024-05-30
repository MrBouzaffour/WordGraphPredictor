package com.prediction;

import com.prediction.Graph.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * The main entry point of the application.
 * This file loads and preprocesses the text data, builds the graph of word transitions,
 * provides a command-line interface for user interaction, and takes user input to predict the next word.
 */
public class App {
    public static void main(String[] args) {
        // Path to the text data file
        String filePath = "data/text_data.txt";

        try {
            // Preprocess the text data
            List<String> preprocessedWords = Preprocessor.preprocessText(filePath);

            // Create a graph and build it from the preprocessed text
            Graph<String> graph = new Graph<>();
            for (int i = 0; i < preprocessedWords.size() - 1; i++) {
                String currentWord = preprocessedWords.get(i);
                String nextWord = preprocessedWords.get(i + 1);
                graph.addEdge(currentWord, nextWord, 1); // Increment weight by 1 for each transition
            }
            // Initialize the predictor with the built graph
            Predictor predictor = new Predictor(graph);

            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Command-line interface for user interaction
            System.out.println("Word Prediction System \n");
            System.out.println("Training completed.");
            System.out.println("Type a word to predict the next word, or type 'exit' to quit.\n");

            while (true) {
                System.out.print("Enter a word: ");
                String input = scanner.nextLine();

                // Exit the loop if the user types "exit"
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Predict the next word
                String currentWord = input.toLowerCase();
                String predictedWord = predictor.predictNextWord(currentWord);

                // Display the prediction
                if (predictedWord != null) {
                    System.out.println("The predicted next word after '" + currentWord + "' is: " + predictedWord);
                } else {
                    System.out.println("No prediction can be made for the word: " + currentWord);
                }
            }

            // Close the scanner
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
