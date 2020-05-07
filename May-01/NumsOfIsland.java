class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int ans = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * nc + j);
                    grid[i][j] = '0'; //masked as visited
                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        int r = id / nc;
                        int c = id % nc;
                        //up
                        if (r - 1 >= 0 && grid[r-1][c] == '1') {
                            queue.add((r-1)*nc + c);
                            grid[r-1][c] = '0'; //masked as visited
                        }
                        //down
                        if (r + 1 < nr && grid[r+1][c] == '1') {
                            queue.add((r+1)*nc + c);
                            grid[r+1][c] = '0';
                        }
                        //left
                        if (c - 1 >= 0 && grid[r][c-1] == '1') {
                            queue.add(r *nc + c-1);
                            grid[r][c-1] = '0';
                        }
                        //right
                        if (r + 1 < nc && grid[r][c+1] == '1') {
                            queue.add(r * nc + c + 1);
                            grid[r][c+1] = '0';
                        }
                    }

                }
            }
        }
        return ans;
    }


}
