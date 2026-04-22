package Graph;

import java.util.Arrays;
import java.util.List;

import java.util.*;

public class DijkstraWithSet {
    
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int id, dist;
        Node(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, List<List<Edge>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        TreeSet<Node> set = new TreeSet<>((a, b) -> {
            if (a.dist == b.dist) {
                return Integer.compare(a.id, b.id);
            }
            return Integer.compare(a.dist, b.dist);
        });

        set.add(new Node(src, 0));

        while (!set.isEmpty()) {
            Node curr = set.pollFirst();
            int u = curr.id;

            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    
                    if (dist[v] != Integer.MAX_VALUE) {
                        set.remove(new Node(v, dist[v]));
                    }

                    dist[v] = dist[u] + weight;
                    set.add(new Node(v, dist[v]));
                }
            }
        }
        
        return dist;
    }

    // --- Driver code to test the algorithm ---
    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Creating a sample graph
        adj.get(0).add(new Edge(1, 9));
        adj.get(0).add(new Edge(2, 6));
        adj.get(0).add(new Edge(3, 5));
        adj.get(0).add(new Edge(4, 3));
        adj.get(2).add(new Edge(1, 2));
        adj.get(2).add(new Edge(3, 4));

        int source = 0;
        int[] shortestDistances = dijkstra(V, adj, source);

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + shortestDistances[i]);
        }
    }
}