class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        // Top + Bottom
        for (int i = 0; i < col; i++) {
            dfs(0, i, pac, heights);
            dfs(row - 1, i, atl, heights);
        }

        // Left + Right
        for (int j = 0; j < row; j++) {
            dfs(j, 0, pac, heights);
            dfs(j, col - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length)
                continue;

            if (ocean[nr][nc])
                continue;

            if (heights[nr][nc] < heights[r][c])
                continue;

            dfs(nr, nc, ocean, heights);
        }
    }
}