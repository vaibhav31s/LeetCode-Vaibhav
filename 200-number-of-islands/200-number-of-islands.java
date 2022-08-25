class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j,grid.length, grid[i].length);
                    count++;
                }
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, int i, int j, int r, int c){
        if(i >= r || j >= c || i < 0 || j < 0 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i+1, j, r, c);
        dfs(grid, i, j+1, r, c);
        dfs(grid, i-1,j , r, c);
        dfs(grid, i, j- 1, r, c);
        
    }
    
    
}