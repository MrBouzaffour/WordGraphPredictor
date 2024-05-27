package main.java.com.prediction.Graph;
import java.util.*;

public class Edge<V> implements Edge_interface<V> {

    private final Vertex<V> source;
    private final Vertex<V> destination;
    private final double weight;

    public Edge(Vertex<V> source, Vertex<V> destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public Vertex<V> getSource() {
        return source;
    }

    @Override
    public Vertex<V> getDestination() {
        return destination;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
