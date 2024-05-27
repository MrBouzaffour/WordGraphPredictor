package test.java.com.prediction;

import main.java.com.prediction.Graph.Edge;
import main.java.com.prediction.Graph.Graph;
import main.java.com.prediction.Graph.Vertex;

/**
 *  Contains a regression test for the Graph class, we are testing :
 * - creating of a graph
 * - addition of edges and vertices
 * - connection of edges and the weight
 * */

public class GraphTest {

    public static void main(String[] args) {
        // Create a graph
        Graph<String> graph = new Graph<>();

        // Test adding vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        // Test adding edges
        graph.addEdge("A", "B", 1.0);
        graph.addEdge("A", "C", 2.0);
        graph.addEdge("B", "C", 3.0);

        // Check vertices
        if (graph.getVertices().size() != 3) {
            System.out.println("Test Failed: Incorrect number of vertices.");
        } else {
            System.out.println("Test Passed: Correct number of vertices.");
        }

        // Check edges

        boolean edgeTestPassed = true;
        for (Vertex<String> vertex : graph.getVertices()) {
            if (vertex.getData().equals("A")) {
                if (vertex.getEdges().size() != 2) edgeTestPassed = false;
            } else if (vertex.getData().equals("B")) {
                if (vertex.getEdges().size() != 1) edgeTestPassed = false;
            } else if (vertex.getData().equals("C")) {
                if (vertex.getEdges().size() != 0) edgeTestPassed = false;
            }
        }

        if (edgeTestPassed) {
            System.out.println("Test Passed: Correct number of edges.");
        } else {
            System.out.println("Test Failed: Incorrect number of edges.");
        }

        // Test edge weights and connections
        boolean connectionTestPassed = true;
        for (Vertex<String> vertex : graph.getVertices()) {
            for (Edge<String> edge : vertex.getEdges()) {
                if (vertex.getData().equals("A")) {
                    if (edge.getDestination().getData().equals("B") && edge.getWeight() != 1.0) {
                        connectionTestPassed = false;
                    }
                    if (edge.getDestination().getData().equals("C") && edge.getWeight() != 2.0) {
                        connectionTestPassed = false;
                    }
                } else if (vertex.getData().equals("B")) {
                    if (edge.getDestination().getData().equals("C") && edge.getWeight() != 3.0) {
                        connectionTestPassed = false;
                    }
                }
            }
        }

        if (connectionTestPassed) {
            System.out.println("Test Passed: Correct edge connections and weights.");
        } else {
            System.out.println("Test Failed: Incorrect edge connections or weights.");
        }

    }
}
