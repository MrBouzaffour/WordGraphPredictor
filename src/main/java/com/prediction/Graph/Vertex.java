package main.java.com.prediction.Graph;
import java.util.*;


/**
* A Vertex class represents a vertex in a graph, holding the data associated with the vertex
* and a list of edges connected to it.
*/

public class Vertex<V>{

    private final V data;  // The data that will be stored in the vertex
    private final List<Edge<V>> edges;  // List of all the edges for this vertex

    /**
     * Constructs a new vertex with the specified data.
     *
     * @param data the data to be stored in this vertex
     */
    public Vertex(V data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    /**
     * Returns the data stored in this vertex.
     *
     * @return the data stored in this vertex
     */
    public V getData() {
        return data;
    }

    /**
     * Returns the list of edges connected to this vertex.
     *
     * @return a list of edges connected to this vertex
     */
    public List<Edge<V>> getEdges() {
        return edges;
    }

    /**
     * Adds an edge to the list of edges connected to this vertex.
     *
     * @param edge the edge to be added
     */
    public void addEdge(Edge<V> edge) {
        edges.add(edge);
    }
}
