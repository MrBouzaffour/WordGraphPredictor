package com.prediction;

import com.prediction.Graph.Graph;
import com.prediction.Graph.Vertex;
import com.prediction.Graph.Edge;

import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains the prediction logic.
 * This file uses the graph to predict the next word and provides a method to get the next word
 * based on the current sequence of words input by the user.
 */
public class Predictor {
    private final Graph<String> graph;

    /**
     * Constructor to initialize the Predictor with a Graph object.
     * @param graph The Graph object containing the word transitions and their frequencies.
     */
    public Predictor(Graph<String> graph) {
        this.graph = graph;
    }

    /**
     * Predicts the next word based on the current sequence of words.
     * @param currentWords The current sequence of words input by the user.
     * @return The predicted next word, or null if no prediction can be made.
     */
    public String predictNextWord(String currentWords) {
        String[] words = currentWords.split("\\s+");
        String lastWord = words[words.length - 1];

        Map<String, Double> candidateWords = new HashMap<>();

        // Iterate through all words in the sequence
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            Vertex<String> currentVertex = null;
            for (Vertex<String> vertex : graph.getVertices()) {
                if (vertex.getData().equals(word)) {
                    currentVertex = vertex;
                    break;
                }
            }

            if (currentVertex == null) {
                continue;  // Move to the next word in the sequence if not found
            }

            List<Edge<String>> edges = currentVertex.getEdges();
            for (Edge<String> edge : edges) {
                String nextWord = edge.getDestination().getData();
                if (!nextWord.equals(word)) {
                    candidateWords.put(nextWord, candidateWords.getOrDefault(nextWord, 0.0) + edge.getWeight());
                }
            }
        }

        // Find the word with the highest accumulated weight
        String predictedWord = null;
        double maxWeight = -1;
        for (Map.Entry<String, Double> entry : candidateWords.entrySet()) {
            if (entry.getValue() > maxWeight) {
                maxWeight = entry.getValue();
                predictedWord = entry.getKey();
            }
        }

        return predictedWord;
    }

    public static void main(String[] args) {
        try {
            // Example usage of the Predictor class
            Graph<String> graph = new Graph<>();

            // Sample text to build the graph
            List<String> words = Preprocessor.preprocessText("data/text_data.txt");

            // Building the graph with the sample text
            for (int i = 0; i < words.size() - 1; i++) {
                String currentWord = words.get(i);
                String nextWord = words.get(i + 1);
                graph.addEdge(currentWord, nextWord, 1); // Increment weight by 1 for each transition
            }

            // Create a Predictor instance with the built graph
            Predictor predictor = new Predictor(graph);

            // Predict the next word after a sequence of words
            String currentWords = "wise old";
            String predictedWord = predictor.predictNextWord(currentWords);

            if (predictedWord != null) {
                System.out.println("The predicted next word after '" + currentWords + "' is: " + predictedWord);
            } else {
                System.out.println("No prediction can be made for the words: " + currentWords);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
