class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int answer = getSum(grid);
        
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) flipRow(grid[i]);
        }
            
        for (int j = 0; j < m; j++) {
            flipCol(grid, j);
        }
        return getSum(grid);
    }

    
    public int getSum(int[][] grid) {
        int sum = 0;

        for (int[] x : grid) {
            StringBuilder sb = new StringBuilder();
            for (int xx : x) {
                sb.append(xx+ "");
            }
            sum += Integer.parseInt(sb.toString(), 2);
        }

        return sum;
    }

    public void flipRow(int[] g) {
        for (int i = 0; i < g.length; i++) {
            if (g[i] == 0) {
                g[i] = 1;
            } else {
                g[i] = 0;
            }
        }
    }
    
    public void flipCol(int[][] g, int col) {
        int zeros = 0, ones = 0;
        
        for (int i = 0; i < g.length; i++) {
            if (g[i][col] == 0) {
                zeros++;
            } else {
                ones++;
            }
        }
        
        if (zeros >= ones) {
            for (int i = 0; i < g.length; i++) {
                if (g[i][col] == 0) {
                    g[i][col] = 1;
                } else {
                    g[i][col] = 0;
                }
            }
        }
        
    }
}