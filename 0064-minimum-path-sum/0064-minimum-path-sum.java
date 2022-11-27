class Solution {
    Integer[][] dp = new Integer[1022][1022];
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return dfs(grid, 0,0, m,n);
        
    }
    
    int dfs(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE;
        if(i == m - 1 && j == n - 1) return grid[i][j];
        if(dp[i][j] != null) return dp[i][j];
        int down = dfs(grid, i + 1, j, m, n) ;
        int right = dfs(grid, i , j + 1, m, n);
        return dp[i][j] = Math.min(down, right)+ grid[i][j];
    }
}