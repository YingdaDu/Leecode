class solution {
    private static int numberOfcluster(char[][] board, int n) {
        int count = 0;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(board, visited, i, j, board[i][j]);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] board, boolean[][] visited, int i, int j, char c) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j] || board[i][j] != c) {
            return;
        }
        visited[i][j] = true;

        dfs(board, visited, i-1, j, c);
        dfs(board, visited, i+1, j, c);
        dfs(board, visited, i, j-1, c);
        dfs(board, visited, i, j+1, c);
    }
}
