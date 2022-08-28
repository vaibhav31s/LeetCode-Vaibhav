class Solution {
    public int closedIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for(int j = 0; j < c; j++){
            if(grid[0][j] == 0) dfs(grid,0,j,r,c);
            if(grid[r-1][j] == 0) dfs(grid,r-1,j,r,c);
        }
        for(int i = 0; i < r; i++){
            if(grid[i][0] == 0) dfs(grid,i,0,r,c);
            if(grid[i][c-1] == 0) dfs(grid,i,c-1,r,c);
        }
        
        int count = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0){
                    count++;
                    dfs(grid, i, j, r,c);
                }
            }
        }
        
        
       
        
        return count;
        
    }
    
    void dfs(int[][] grid, int i, int j, int r,int c){
        if(i < 0 || j <0 || i >= r || j >= c || grid[i][j] == 1) return;
        grid[i][j] = 1;
        
        
        dfs(grid, i-1, j, r, c);
        dfs(grid, i+1, j, r, c);
        dfs(grid, i, j-1, r, c);
        dfs(grid, i, j+1, r, c);
        
    }
}