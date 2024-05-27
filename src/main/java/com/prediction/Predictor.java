package main.java.com.prediction;

import main.java.com.prediction.Graph.Graph;
import main.java.com.prediction.Graph.Vertex;
import main.java.com.prediction.Graph.Edge;

import java.util.List;

/**
 * Contains the prediction logic.
 * This file uses the graph to predict the next character and provides a method to get the next character
 * based on the current character input by the user.
 */
public class Predictor {
    private final Graph<Character> graph;

    /**
     * Constructor to initialize the Predictor with a Graph object.
     * @param graph The Graph object containing the character transitions and their frequencies.
     */
    public Predictor(Graph<Character> graph) {
        this.graph = graph;
    }

    /**
     * Predicts the next character based on the current character.
     * @param currentChar The current character input by the user.
     * @return The predicted next character, or null if no prediction can be made.
     */
    public Character predictNextChar(char currentChar) {
        Vertex<Character> currentVertex = graph.getVertices().stream()
                .filter(v -> v.getData() == currentChar)
                .findFirst()
                .orElse(null);

        if (currentVertex == null) {
            return null;
        }

        List<Edge<Character>> edges = currentVertex.getEdges();
        Edge<Character> maxEdge = edges.stream()
                .max((e1, e2) -> Double.compare(e1.getWeight(), e2.getWeight()))
                .orElse(null);

        return (maxEdge != null) ? maxEdge.getDestination().getData() : null;
    }


}
