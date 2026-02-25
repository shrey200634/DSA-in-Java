package Graph;

public class MatrixRepUndirectedG {
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int[][] adj = new int[V][V];

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        printMatrix(adj);
    }

    static void addEdge(int[][] adj, int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1; // Because it is an undirected graph
    }

    static void printMatrix(int[][] adj) {
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
