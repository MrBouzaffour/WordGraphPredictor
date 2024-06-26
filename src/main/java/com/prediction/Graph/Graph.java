package com.prediction.Graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The Graph class represents a graph data structure containing vertices and edges.
 * It provides methods to add vertices and edges, and to retrieve the collection of vertices.
 */
public class Graph<V> {
    private final Map<V, Vertex<V>> vertices;  // Map to store vertices by their data

    /**
     * Constructs a new graph.
     */
    public Graph() {
        this.vertices = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph with the specified data.
     *
     * @param data the data to be stored in the vertex
     */
    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    /**
     * Adds an edge to the graph with the specified source, destination, and weight.
     * If the source or destination vertices do not exist, they are created.
     *
     * @param source the source vertex data
     * @param destination the destination vertex data
     * @param weight the weight of the edge
     */
    public void addEdge(V source, V destination, double weight) {
        if (!vertices.containsKey(source)) addVertex(source);
        if (!vertices.containsKey(destination)) addVertex(destination);

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(destination);

        boolean edgeExists = false;
        for (Edge<V> edge : sourceVertex.getEdges()) {
            if (edge.getDestination().equals(destVertex)) {
                edge.incrementWeight(weight);
                edgeExists = true;
                break;
            }
        }

        if (!edgeExists) {
            sourceVertex.addEdge(new Edge<>(sourceVertex, destVertex, weight));
        }
    }

    /**
     * Returns the collection of vertices in the graph.
     *
     * @return a collection of vertices
     */
    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}
