class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(n == 1) return new int[]{-1};
        for(int i =0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j < n -1 && grid[i][j] == 1 && grid[i][j + 1] == -1){
                    grid[i][j] = 100;
                    grid[i][j+1] = 100;
                    
                }
            }
            
            // System.out.println(Arrays.toString(grid[i]));
        }
        
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            int a  =dfs(grid, 0, i, m, n);
            if(a == -1){
                answer[i] = -1;
            }else if(a >= n){
                answer[i] = -1;
            }else answer[i] =a;
        }
        
        
    return answer;
    }
    
    int dfs(int[][] g, int i , int j, int m, int n){
        if(i == m ) return j;
        if(i < 0 || j < 0 || i >= m || j >=n || g[i][j] == 100) return -1;
        
        if(g[i][j] == 1) return dfs(g, i+1,j+1,m,n);
        else if(g[i][j] ==  -1) return  dfs(g, i+1, j-1,m,n);
        
        return j;
    }
}