package main.java.com.prediction.Graph;
import java.util.*;

public class Vertex<V> implements Vertex_interface<V>{
    private final V data;
    private final List<Edge<V>> edges;

    public Vertex(V data){
        this.data = data;
        this.edges = new ArrayList<>();
    }
    @Override
    public V getData() {
        return data;
    }
    @Override
    public List<Edge<V>> getEdges() {
        return edges;
    }
    @Override
    public void addEdge(Edge<V> edge) {
        edges.add(edge);
    }
}
