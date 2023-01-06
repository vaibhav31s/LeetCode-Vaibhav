class Solution {
    int n;
    int m;
    int max= 0;
    public int orangesRotting(int[][] grid) {
         n = grid.length;
         m = grid[0].length;
        
        Deque<Pair<Integer, Integer>> rotten = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int  j= 0; j < m; j++){
                if(grid[i][j] == 2){
                    rotten.add(new Pair(i,j));
                }
            }
        }
        
        int count  = 0;
        int[] dx  = {1,-1,0,0};
        int[] dy  = {0,0,1,-1};
        while(!rotten.isEmpty()){
            int nn  = rotten.size();
            while(nn--> 0){
                Pair<Integer,Integer> p = rotten.poll();
                int i = p.getKey();
                int j = p.getValue();
                if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || grid[i][j] == 3) continue;
                grid[i][j] = 3;
                for(int ii = 0; ii < dx.length; ii++){
                     rotten.add(new Pair(i+dx[ii],j+dy[ii]));
                 }
                
            }
            count++;
        }
        
        
        for(int i = 0; i < n; i++){
            for(int  j= 0; j < m; j++){
                if(grid[i][j] == 1){
                   return -1;
                }
            }
        }
        if(count == 0) return 0;
        return count-2;
    }
    
    void dfs(int[][] g, int i, int j, int count){
        if( i < 0 || j < 0 || i >= n || j >= m || g[i][j] == 0 ||  g[i][j] == 3 || g[i][j] == 2)return;
        max = Math.max(count, max);
        g[i][j] = 3;
        
        dfs(g, i+1, j, count+1);
        dfs(g, i-1, j, count+1);
        dfs(g, i, j - 1, count+1);
        dfs(g, i, j + 1, count+1);
        
        
        
    }
}