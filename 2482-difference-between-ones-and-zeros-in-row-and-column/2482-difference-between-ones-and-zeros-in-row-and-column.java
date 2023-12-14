class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] row = new int[n][2];
        int[][] col = new int[m][2];
        for (int i = 0; i < n; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            row[i][0] = zero;
            row[i][1] = one;
        }
        
        for (int j = 0; j < m; j++) {
            int one = 0;
            int zero = 0;
            for (int i = 0; i < n; i++)  {
                if (grid[i][j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            col[j][0] = zero;
            col[j][1] = one;
        }
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = row[i][1] + col[j][1] - row[i][0] - col[j][0];
            }
        }
        
        return grid;
    }
}

