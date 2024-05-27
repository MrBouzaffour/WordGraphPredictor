package main.java.com.prediction.Graph;

public interface Edge_interface<V> {

    Vertex<V> getSource();
    Vertex<V> getDestination();
    double getWeight();
}
