class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int row, col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;

        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        // Left & Right borders
        for(int i = 0; i < row; i++){
            dfs(heights, pac, i, 0);
            dfs(heights, atl, i, col - 1);
        }

        // Top & Bottom borders
        for(int j = 0; j < col; j++){
            dfs(heights, pac, 0, j);
            dfs(heights, atl, row - 1, j);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c){
        if(ocean[r][c]) return;
        ocean[r][c] = true;

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 || nr >= row || nc >= col) continue;
            if(ocean[nr][nc]) continue;
            if(heights[nr][nc] < heights[r][c]) continue;

            dfs(heights, ocean, nr, nc);
        }
    }
}