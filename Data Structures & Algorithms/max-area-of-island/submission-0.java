class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        // base case
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return 0;
        }

        // mark visited
        grid[i][j] = 0;

        // explore all 4 directions
        int area = 1;
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i, j - 1);

        return area;
    }
}