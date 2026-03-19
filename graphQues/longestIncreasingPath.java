package graphQues;
class longestIncreasingPath{

    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        int maxPath = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        // If already calculated, return the stored value
        if (memo[r][c] != 0) return memo[r][c];

        int currentMax = 1; // Base case: the cell itself is a path of length 1

        for (int i = 0; i < 4; i++) {
            int nr = r + delRow[i];
            int nc = c + delCol[i];

            // Check boundaries AND the increasing condition
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length 
                && matrix[nr][nc] > matrix[r][c]) {
                
                int path = 1 + dfs(matrix, nr, nc, memo);
                currentMax = Math.max(currentMax, path);
            }
        }

        memo[r][c] = currentMax; // Store result before returning
        return currentMax;
    }
}
