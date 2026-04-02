package graphQues;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirected {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int pre = edge[1];
            adjMatrix[pre][course] = 1; // Edge from pre -> course
        }

        // 2. State array: 0 = unvisited, 1 = visiting, 2 = visited
        int[] visitStatus = new int[numCourses];

        // 3. Check every node (handles disconnected components)
        for (int i = 0; i < numCourses; i++) {
            if (visitStatus[i] == 0) {
                if (hasCycle(i, adjMatrix, visitStatus, numCourses)) {
                    return false; // Cycle detected
                }
            }
        }
        return true; // No cycles found
    }

    private boolean hasCycle(int curr, int[][] adjMatrix, int[] visitStatus, int n) {
        if (visitStatus[curr] == 1) return true; // Found a back-edge (Cycle!)
        if (visitStatus[curr] == 2) return false; // Already processed this path

        // Mark as 'Visiting'
        visitStatus[curr] = 1;

        // Explore neighbors in the matrix
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (adjMatrix[curr][neighbor] == 1) {
                if (hasCycle(neighbor, adjMatrix, visitStatus, n)) {
                    return true;
                }
            }
        }

        // Mark as 'Visited' (Done with this branch)
        visitStatus[curr] = 2;
        return false;
    }
}

// second method 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] num : prerequisites) {
            int v = num[1];
            int u = num[0];
            graph.get(v).add(u);

        }

        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i, graph, state)) {
                    return false;
                }

            }
        }

        return true;
    }

    public boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1)
            return true;
            if(state[node] == 2) return false;

            state[node] = 1;

            for(int num : graph.get(node)){
                if(dfs(num , graph, state)){
                    return true;
                }
            }

            state[node] = 2;
            return false;
    }
}

    

