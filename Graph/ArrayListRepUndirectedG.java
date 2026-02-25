package Graph;

import java.util.ArrayList;

public class ArrayListRepUndirectedG {
   public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // 1. Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // 2. Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        // 3. Print the graph
        printGraph(adj);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Backlink for undirected graph
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
