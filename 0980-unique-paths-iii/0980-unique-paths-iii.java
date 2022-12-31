class Solution {
    int answer = 0;
    int n,m;
    StringBuilder sb = new StringBuilder();
    int count= 0;
    public int uniquePathsIII(int[][] grid) {
         n = grid.length ;
         m = grid[0].length;
        int startx = 0;
        int starty = 0;
        int endx = 0;
        int endy= 0;
        
        for(int i = 0; i  < n; i++){
            for(int j  = 0; j < m; j++){
                if(grid[i][j] == 1 ) {startx = i; starty= j;}
                if(grid[i][j] == 0) count++;
            }
        }
        dfs(grid,startx +1 , starty,0);
        dfs(grid,startx  - 1, starty,0);
        dfs(grid,startx  , starty + 1,0);
        dfs(grid,startx  , starty -1,0);
        
        
        return answer;
    }
    
    void dfs(int[][] g, int x, int y,  int c){
        if(x < 0 || y < 0 || x >= n || y >= m || g[x][y] == -1  || g[x][y] == 3 || g[x][y] == 1) return; 
        if(g[x][y] == 2){
            if(count == c)
             answer++;
            return;
        }
        int t = g[x][y];
        g[x][y] = 3;
        dfs(g, x + 1, y, c + 1 );
        dfs(g, x -1 , y,  c + 1);
        dfs(g, x, y + 1, c + 1);
        dfs(g, x, y -1, c + 1);
        g[x][y] =t;
    }
}