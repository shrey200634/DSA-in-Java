package Graph;

import java.util.*;

public class PrimsPQVisited {

    static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Class to represent nodes in the Priority Queue
    static class PQNode implements Comparable<PQNode> {
        int vertex;
        int weight;
        int parent;

        public PQNode(int vertex, int weight, int parent) {
            this.vertex = vertex;
            this.weight = weight;
            this.parent = parent;
        }

         @Override
        public int compareTo(PQNode other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

   
    public static void primsAlgorithm(List<List<Edge>> graph, int V) {
         boolean[] visited = new boolean[V];
         PriorityQueue<PQNode> pq = new PriorityQueue<>();
         pq.add(new PQNode(0, 0, -1));

        int totalMstWeight = 0;
        
        System.out.println("Edges in the Minimum Spanning Tree:");
        System.out.println("Edge \tWeight");

         while (!pq.isEmpty()) {
             PQNode current = pq.poll();
            int u = current.vertex;
 
             if (visited[u]) {
                continue;
            }

             visited[u] = true;
            totalMstWeight += current.weight;

             if (current.parent != -1) {
                System.out.println(current.parent + " - " + u + "\t  " + current.weight);
            }

             for (Edge neighbor : graph.get(u)) {
                int v = neighbor.target;
                int weight = neighbor.weight;

                 if (!visited[v]) {
                    pq.add(new PQNode(v, weight, u));
                }
            }
        }

        System.out.println("\nTotal Weight of MST: " + totalMstWeight);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Example Graph Construction
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 6);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 4, 7);
        addEdge(graph, 3, 4, 9);

        primsAlgorithm(graph, V);
    }

    // Helper method to add undirected edges
    private static void addEdge(List<List<Edge>> graph, int src, int dest, int weight) {
        graph.get(src).add(new Edge(dest, weight));
        graph.get(dest).add(new Edge(src, weight));
    }
}