class Solution {
    int max = 0;
    int count =0;
    public int maxAreaOfIsland(int[][] grid) {
            
        for(int i = 0; i < grid.length; i++){
            for(int  j=  0; j < grid[0].length; j++){
            count = 0;
                if(grid[i][j] == 1)
                dfs(grid, i,j, grid.length, grid[i].length);
            }
        }
        return max;
        
    }
    void dfs(int[][] grid, int i, int j , int r, int c){
        if(i >= r || j >= c || i < 0 || j < 0 || grid[i][j] == 0) return;
        
        count++;
        grid[i][j] = 0;
        max = Math.max(count, max);
        dfs(grid, i + 1, j, r, c);
        dfs(grid, i - 1, j, r, c);
        dfs(grid, i , j + 1, r, c);
        dfs(grid, i , j - 1, r, c);

    }
}