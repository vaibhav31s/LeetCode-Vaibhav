class Solution {
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c ; j++){
                if(i*j == 0 || i == r-1 || j == c-1){
                    if(grid[i][j] == 1){
                        dfs(grid,i, j, r, c);
                    }
                }
            }
        }
        int answer =0;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c ; j++){
                if(grid[i][j] == 1) answer++;
            }
        }
        return answer;
    }
    
    void dfs(int[][] grid, int i, int j, int r, int c){
        if(i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(grid, i-1, j, r, c);
        dfs(grid, i+1, j , r, c);
        dfs(grid, i, j - 1, r, c);
        dfs(grid, i, j + 1, r, c);

    }
}