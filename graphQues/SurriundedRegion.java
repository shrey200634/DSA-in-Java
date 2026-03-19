package graphQues;


class SurriundedRegion {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        // Traverse first and last columns
        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                dfs(i, 0, board, visited);
            }
            if (!visited[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, visited);
            }
        }

        // Traverse first and last rows
        for (int j = 0; j < m; j++) {
            if (!visited[0][j] && board[0][j] == 'O') {
                dfs(0, j, board, visited);
            }
            if (!visited[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(n - 1, j, board, visited);
            }
        }

        // Final flip: If it's 'O' and NOT visited, it's surrounded
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board, boolean[][] visited) {
        visited[row][col] = true;
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            // Check boundaries, if it's 'O', and if not already visited
            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length 
                && board[nrow][ncol] == 'O' && !visited[nrow][ncol]) {
                dfs(nrow, ncol, board, visited);
            }
        }
    }
}
    

