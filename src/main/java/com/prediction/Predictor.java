package com.prediction;

import com.prediction.Graph.Graph;
import com.prediction.Graph.Vertex;
import com.prediction.Graph.Edge;

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

        // Iterate through the last few words in the sequence
        for (int i = Math.max(0, words.length - 2); i < words.length; i++) {
            String word = words[i];

            Vertex<String> currentVertex = null;
            for (Vertex<String> vertex : graph.getVertices()) {
                if (vertex.getData().equals(word)) {
                    currentVertex = vertex;
                    break;
                }
            }

            if (currentVertex == null) {
                continue;
            }

            List<Edge<String>> edges = currentVertex.getEdges();
            for (Edge<String> edge : edges) {
                String nextWord = edge.getDestination().getData();
                if (!nextWord.equals(lastWord)) {
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
}
