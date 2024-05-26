package main.java.com.prediction.Graph;
import java.util.List;

public interface Vertex<V> {
    V getData();
    List<Edge<V>> getEdges();
    void addEdge(Edge<V> edge);
}
