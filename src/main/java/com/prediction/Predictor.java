package com.prediction;

/**
 * Contains the prediction logic.
 * This file uses the graph to predict the next character and provides a method to get the next character
 * based on the current character input by the user.
 */
public class Predictor {
    private Graph graph;

    public Predictor(Graph graph) {
        this.graph = graph;
    }

    public Character predictNextChar(char currentChar) {
        return this.graph.getNextChar(currentChar);
    }
}
