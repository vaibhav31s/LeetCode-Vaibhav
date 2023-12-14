class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                }
            }
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++)  {
                if (grid[i][j] == 1) {
                    col[j]++;
                }
            }
        }
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = row[i] + col[j] - (n - row[i]) - (m - col[j]);
            }
        }
        
        return grid;
    }
}

