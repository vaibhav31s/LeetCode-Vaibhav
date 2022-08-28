class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int r  = grid1.length, c = grid2[0].length;
        int[][] grid = new int[r][c];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                if(grid1[i][j] == 1 && grid2[i][j] == 1){
                    grid[i][j]= 1 ;
                }
            }
        }
        
        int answer =0;
        for(int i =0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                   int count2 = cI(grid2,i,j,r,c);
                   int count1 = cI(grid, i, j, r,c);
                    if(count2 == count1){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    int cI(int[][] grid, int i, int j , int r, int c){
        if(i < 0 || j < 0 || i >= r || j  >= c || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        
        return 1 + cI(grid, i - 1,j, r, c) + cI(grid, i + 1,j, r, c) + cI(grid, i ,j+ 1, r, c) +cI(grid, i ,j -1, r, c);
        
    }
    void dfs(int[][] grid, int i,int j,int r,int c){
        if(i < 0 || j < 0 || i >= r || j  >= c || grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(grid, i-1, j, r, c);
        dfs(grid, i+1, j, r, c);
        dfs(grid, i, j+1, r, c);
        dfs(grid, i, j-1, r, c);

    }
}