class Solution {
    public int numIslands(char[][] grid) {
        int rl=grid.length;
        int cl=grid[0].length;
        int noi=0;

        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]=='1'){
                    noi+=1;
                    dfs(grid,i,j);
                }
            }
        }

        return noi;
    }

    private void dfs(char[][] grid,int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == '0')return ;
        grid[row][col]='0';
        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
        dfs(grid,row-1,col);
        dfs(grid,row,col-1);
    }
}
