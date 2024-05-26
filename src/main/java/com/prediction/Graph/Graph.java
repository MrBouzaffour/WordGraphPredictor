package com.prediction;

/**
 * Graph data structure
 * This file contains methods to add edges between characters and increment the weight of existing edges.
 * It also provides a method to get the most likely next character based on the highest edge weight.
 */
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<Character, Map<Character, Integer>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(char currentChar, char nextChar) {
        this.graph.computeIfAbsent(currentChar, k -> new HashMap<>())
                  .merge(nextChar, 1, Integer::sum);
    }

    public Character getNextChar(char currentChar) {
            return null;
        }
        return this.graph.get(currentChar).entrySet().stream()
                         .max(Map.Entry.comparingByValue())
                         .map(Map.Entry::getKey)
                         .orElse(null);
    }
}
