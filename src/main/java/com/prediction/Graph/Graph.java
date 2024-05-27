package main.java.com.prediction.Graph;
import java.util.*;


/**
 * The Graph class represents a graph data structure containing vertices and edges.
 * It provides methods to add vertices and edges, and to retrieve the collection of vertices.
 * */
public class Graph<V> implements Graph_interface<V> {

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
    @Override
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
    @Override
    public void addEdge(V source, V destination, double weight) {
        if (!vertices.containsKey(source)) addVertex(source);
        if (!vertices.containsKey(destination)) addVertex(destination);

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(destination);

        sourceVertex.addEdge(new Edge<>(sourceVertex, destVertex, weight));
    }

    /**
     * Returns the collection of vertices in the graph.
     *
     * @return a collection of vertices
     */
    @Override
    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}
