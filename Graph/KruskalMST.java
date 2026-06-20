package Graph;

import java.util.*;

public class KruskalMST {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Sort edges based on weight in ascending order
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // Disjoint Set Union (DSU) / Union-Find data structure
    static class DSU {
        int[] parent, rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // Initially, every node is its own parent
                rank[i] = 0;   // Initial rank is 0
            }
        }

        // Find with Path Compression
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            // Path compression: attach the node directly to the root
            return parent[i] = find(parent[i]);
        }

        // Union by Rank
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            // Cycle detected: they are already in the same component
            if (rootX == rootY) return false; 

            // Attach the smaller rank tree under the root of the higher rank tree
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                // If ranks are same, make one root and increment its rank
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    // Main function to construct the MST
    public static void kruskal(int vertices, List<Edge> edges) {
        // Step 1: Sort all the edges
        Collections.sort(edges);

        // Allocate memory for creating V subsets
        DSU dsu = new DSU(vertices);

        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        // Step 2 & 3: Iterate through sorted edges and apply DSU
        for (Edge edge : edges) {
            // If union is successful, no cycle is formed
            if (dsu.union(edge.src, edge.dest)) {
                mst.add(edge);
                mstWeight += edge.weight;
                
                // Optimization: MST will have exactly (V - 1) edges
                if (mst.size() == vertices - 1) {
                    break; 
                }
            }
        }

        // Output results
        System.out.println("Edges in the constructed MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
        System.out.println("Minimum Spanning Tree Total Weight: " + mstWeight);
    }

    public static void main(String[] args) {
        int V = 4; 
        List<Edge> edges = new ArrayList<>();

        // Example Graph edges (src, dest, weight)
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        kruskal(V, edges);
    }
}