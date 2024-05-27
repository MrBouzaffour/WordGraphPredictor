package main.java.com.prediction.Graph;

public interface Edge_interface<V> {

    Vertex<V> getSource();  // Returns the source vertex of the edge
    Vertex<V> getDestination(); //Returns the destination vertex of the edge
    double getWeight(); // Returns the weight of the edge.
}
