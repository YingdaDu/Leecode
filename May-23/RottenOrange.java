public int orangesRotting(int[][] grid) {
        //BFS
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { //how many oranges
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int level = 0;
        if(count == 0) return 0; //import

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[] d : dir) {
                    int r1 = r + d[0];
                    int c1 = c + d[1];
                    if (r1 >= 0 && r1 < row && c1 >=0 && c1 < col && grid[r1][c1] == 1) {
                        queue.add(new int[]{r1, c1});
                        count--;
                        grid[r1][c1] = 2; //mark as rotten
                    }
                }
            }
            level++;
        }
        //reason to return level-1 is the last level is to check no other oranges available, thus
        //need to -1 in result
        return count == 0 ? level-1 : -1;
}