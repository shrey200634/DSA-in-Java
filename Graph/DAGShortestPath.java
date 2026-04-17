package Graph;

import java.util.*;

class Edge {
    int target;
    int weight;

    Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class DAGShortestPath {

    // Helper method to perform DFS for Topological Sorting
    private void topoSort(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Edge>> adj) {
        visited[node] = true;

        for (Edge edge : adj.get(node)) {
            if (!visited[edge.target]) {
                topoSort(edge.target, visited, stack, adj);
            }
        }
        
        stack.push(node);
    }

    public int[] shortestPath(int V, int[][] edges, int src) {
        // Step 1: Create the Adjacency List representation of the graph
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Edge(v, wt));
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stack, adj);
            }
        }

        // Step 3: Initialize distances and relax edges
        int[] dist = new int[V];
        // Use Integer.MAX_VALUE to represent Infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance to the source node is always 0

        // Process nodes in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            // If the node has been reached from the source, check its neighbors
            if (dist[node] != Integer.MAX_VALUE) {
                for (Edge edge : adj.get(node)) {
                    // Relaxation step: If we find a shorter path, update it
                    if (dist[node] + edge.weight < dist[edge.target]) {
                        dist[edge.target] = dist[node] + edge.weight;
                    }
                }
            }
        }
        
        return dist;
    }

    // --- Main Method for Testing ---
    public static void main(String[] args) {
        int V = 6; 
        
        // Graph edges represented as {source, destination, weight}
        int[][] edges = {
            {0, 1, 2}, 
            {0, 4, 1}, 
            {1, 2, 3},
            {4, 2, 2}, 
            {4, 5, 4}, 
            {2, 3, 6}, 
            {5, 3, 1}
        };
        int src = 0;

        DAGShortestPath solver = new DAGShortestPath();
        int[] distances = solver.shortestPath(V, edges, src);

        System.out.println("Shortest distances from source node " + src + ":");
        for (int i = 0; i < V; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("Node " + i + ": Infinity (Unreachable)");
            } else {
                System.out.println("Node " + i + ": " + distances[i]);
            }
        }
    }
}