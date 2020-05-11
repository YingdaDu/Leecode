public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }


    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0, 1}};
        int n =  grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if(x < 0 || y < 0 || x == n || y == m || grid[x][y] == 0){
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}