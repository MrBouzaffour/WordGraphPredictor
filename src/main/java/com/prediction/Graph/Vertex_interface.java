package main.java.com.prediction.Graph;
import java.util.List;

public interface Vertex_interface<V> {
    V getData();
    List<Edge<V>> getEdges();
    void addEdge(Edge<V> edge);
}
