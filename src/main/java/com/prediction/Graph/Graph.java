package main.java.com.prediction.Graph;
import java.util.*;

public class Graph<V> implements Graph_interface<V> {

    private final Map<V, Vertex<V>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    @Override
    public void addEdge(V source, V destination, double weight) {
        if (!vertices.containsKey(source)) addVertex(source);
        if (!vertices.containsKey(destination)) addVertex(destination);

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(destination);

        sourceVertex.addEdge(new Edge<>(sourceVertex, destVertex, weight));

    }

    @Override
    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }


}
