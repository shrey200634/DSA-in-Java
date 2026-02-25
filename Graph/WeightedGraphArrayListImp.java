package Graph;

import java.util.ArrayList;

public class WeightedGraphArrayListImp {
static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        // The list now stores Edge objects instead of just Integers
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Edge>());
        }

        // Adding edges: (source, destination, weight)
        addEdge(adj, 0, 1, 10);
        addEdge(adj, 0, 2, 15);
        addEdge(adj, 1, 2, 5);
        addEdge(adj, 1, 3, 2);
        addEdge(adj, 2, 3, 8);

        printGraph(adj);
    }

    static void addEdge(ArrayList<ArrayList<Edge>> adj, int u, int v, int weight) {
        // For an undirected weighted graph:
        adj.get(u).add(new Edge(v, weight));
        adj.get(v).add(new Edge(u, weight));
    }

    static void printGraph(ArrayList<ArrayList<Edge>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Edge edge : adj.get(i)) {
                System.out.print(edge.target + "(weight: " + edge.weight + ") ");
            }
            System.out.println();
        }
    
    }}
