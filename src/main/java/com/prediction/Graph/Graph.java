package main.java.com.prediction.Graph;
import java.util.Collection;


public interface Graph<V> {
    /*
    * The Graph interface defines the essential operations for a graph data structure,
    * supporting the addition of vertices and edges, retrieval of all vertices,
    * and checking the type of the graph (directed or undirected)
    **/

    // Adds an edge between the source and destination vertices with a specified weight, it Creates the vertices if they do not exist.
    void addVertex(V data);

    // Adds a vertex to the graph with the specified data
    void addEdge(V source, V destination, double weight);

    // Retrieves all vertices in the graph
    Collection<Vertex<V>> getVertices();

    // Returns the type of the graph (directed or undirected).
    GraphType getGraphType();
}

