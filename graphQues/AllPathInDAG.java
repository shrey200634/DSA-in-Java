import java.util.ArrayList;
import java.util.List;

class AllPathInDAG {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        int n = graph.length;
        boolean[] visited = new boolean[n]; // The visited array you requested
        currentPath.add(0);
        visited[0] = true;
        dfs(graph, 0, n - 1, currentPath, result, visited);
        return result; 
    }
    private void dfs(int[][] graph, int currentNode, int targetNode, 
                     List<Integer> currentPath, List<List<Integer>> result, 
                     boolean[] visited) {
        
        if (currentNode == targetNode) {
            result.add(new ArrayList<>(currentPath));
            return; 
        }
        for (int nextNode : graph[currentNode]) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                currentPath.add(nextNode);
                dfs(graph, nextNode, targetNode, currentPath, result, visited);
                
                visited[nextNode] = false;
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
}




