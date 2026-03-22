package graphQues;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: uncolored, 1: colorA, -1: colorB

        for (int i = 0; i < n; i++) {
            // Start BFS if node is not colored
            if (color[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1; // Start coloring with 1

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int neighbor : graph[curr]) {
                        if (color[neighbor] == 0) {
                            // Color with opposite of current node
                            color[neighbor] = -color[curr];
                            queue.add(neighbor);
                        } else if (color[neighbor] == color[curr]) {
                            // Conflict found
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}