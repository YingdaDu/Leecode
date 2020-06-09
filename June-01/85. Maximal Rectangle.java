class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] grid = new int[r][c];
        buildHistogram(matrix, grid);
        int max = 0;
        for (int i = 0; i < r; i++) {
            max = Math.max(max, maxRec(grid, i));
        }
        return max;
    }

    private void buildHistogram (char[][] matrix, int[][] grid) {
        for (int j = 0; j < matrix[0].length; j++) {//first row
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i-1][j] + 1;
                }
            }
        }
    }

    private int maxRec(int[][] grid, int row) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = grid[0].length;
        int max = 0;

        for (int j = 0; j < n; j++) {
            while (stack.peek() != -1 && grid[row][stack.peek()] >= grid[row][j]) {
                max = Math.max(max, grid[row][stack.pop()] * (j - stack.peek() - 1));
            }
            stack.push(j);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, grid[row][stack.pop()] * (n - stack.peek() - 1));
        }
        return max;
    }
}