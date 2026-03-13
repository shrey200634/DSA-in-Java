package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleMatrix {
     public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j, grid, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int r, int c, char[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        char target = grid[r][c];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, -1, -1});
        visited[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            int pR = curr[2];
            int pC = curr[3];

            for (int i = 0; i < 4; i++) {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == target) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, currR, currC});
                    } else if (nr != pR || nc != pC) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}
