package main.java.com.prediction.Graph;
import java.util.*;

/**
 * The Edge class represents an edge in a graph, connecting two vertices (source and destination) with an associated weight
 */
public class Edge<V> implements Edge_interface<V> {

    private final Vertex<V> source;     // The source vertex of the edge
    private final Vertex<V> destination; // The destination vertex of the edge
    private final double weight;        // The weight of the edge

    /**
     * Constructs a new edge with the specified source, destination, and weight.
     *
     * @param source the source vertex of the edge
     * @param destination the destination vertex of the edge
     * @param weight the weight of the edge
     */
    public Edge(Vertex<V> source, Vertex<V> destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Returns the source vertex of the edge.
     *
     * @return the source vertex of the edge
     */
    @Override
    public Vertex<V> getSource() {
        return source;
    }

    /**
     * Returns the destination vertex of the edge.
     *
     * @return the destination vertex of the edge
     */
    @Override
    public Vertex<V> getDestination() {
        return destination;
    }

    /**
     * Returns the weight of the edge.
     *
     * @return the weight of the edge
     */
    @Override
    public double getWeight() {
        return weight;
    }
}
