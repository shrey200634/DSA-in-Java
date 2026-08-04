import java.util.ArrayList;
import java.util.List;

public class RerootDp{

    List<Integer>[] graph;
    int[] count; // Size of subtree rooted at node
    int[] ans;   // Sum of distances

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        count = new int[n];
        ans = new int[n];

        // First DFS
        dfs1(0, -1, 0);

        // Second DFS (Reroot DP)
        dfs2(0, -1, n);

        return ans;
    }

    // Computes:
    // 1. count[node] = size of subtree
    // 2. ans[0] = sum of distances from root(0)
    private void dfs1(int node, int parent, int depth) {

        ans[0] += depth;
        count[node] = 1;

        for (int child : graph[node]) {

            if (child == parent)
                continue;

            dfs1(child, node, depth + 1);

            count[node] += count[child];
        }
    }

    // Reroot DP
    private void dfs2(int node, int parent, int n) {

        for (int child : graph[node]) {

            if (child == parent)
                continue;

            ans[child] = ans[node] - count[child] + (n - count[child]);

            dfs2(child, node, n);
        }
    }
}
