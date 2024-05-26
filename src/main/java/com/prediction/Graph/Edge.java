package main.java.com.prediction.Graph;

public interface Edge<V> {
    Vertex<V> getSource();
    Vertex<V> getDestination();
    double getWeight();
}
