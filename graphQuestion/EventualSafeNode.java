package graphQues;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNode {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; 
        List<Integer> safeNodes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, state)) {
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    
    private boolean dfs(int[][] graph, int node, int[] state) {
        if (state[node] > 0) {
            return state[node] == 2;
        }
        
        state[node] = 1;
        
        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, state)) {
                return false;
            }
        }
        
        state[node] = 2;
        return true;
    }
    
}
