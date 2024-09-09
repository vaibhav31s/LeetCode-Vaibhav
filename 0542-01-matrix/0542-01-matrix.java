class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        Deque<Pair<Integer, Integer>> dq = new LinkedList<>();
        
        
        for (int[] x : ans) Arrays.fill(x, -1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    dq.add(new Pair<>(i, j));
                    ans[i][j] = 0;
                } 
            }
        }
        
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0},  {-1, 0}};
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                Pair<Integer, Integer> lastPair = dq.poll();
                int x = lastPair.getKey();
                int y = lastPair.getValue();
                
                for (int[] curDir : direction) {
                    int xx = x + curDir[0];
                    int yy = y + curDir[1];
                    if (validCoord(xx, yy, n, m, ans)) {
                        ans[xx][yy] = 1 + ans[x][y];
                        dq.add(new Pair<>(xx, yy));
                    }
                }
            }
                    
        }
        return ans;
    }
                    
    boolean validCoord(int x, int y, int n, int m, int[][] ans) {
        if (x < 0 || y < 0 || x >= n || y >= m || ans[x][y] != -1) return false;
        
        return true;
    }
    
    
}