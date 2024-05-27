package main.java.com.prediction.Graph;
import java.util.List;

public interface Vertex_interface<V> {

    V getData();    // returns the data stored in this vertex
    List<Edge<V>> getEdges();   // returns the list of edges connected to this vertex
    void addEdge(Edge<V> edge);     // adds an edge to the list of edges connected to this vertex
}
