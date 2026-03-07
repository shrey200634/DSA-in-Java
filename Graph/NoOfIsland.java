package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {



    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols]; 
        int islandCount = 0;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true; 
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        
                        for (int[] dir : directions) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            
                            if (r >= 0 && r < rows && c >= 0 && c < cols 
                                && grid[r][c] == '1' && !visited[r][c]) {
                                visited[r][c] = true;
                                queue.offer(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return islandCount;
    }
}





    

