class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        for (int row = 0; row < n; row++) {
            if (grid[row][0] == 0) flipRow(grid[row]);
        }
            
        for (int col = 0; col < m; col++) {
            flipCol(grid, col);
        }
        return getSum(grid);
    }

    
    public int getSum(int[][] grid) {
        int sum = 0;

        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            
            for (int val : row) {
                sb.append(val + "");
            }
            sum += Integer.parseInt(sb.toString(), 2);
        }
        return sum;
    }

    public void flipRow(int[] curRow) {
        for (int row = 0; row < curRow.length; row++) {
            if (curRow[row] == 0) {
                curRow[row] = 1;
            } else {
                curRow[row] = 0;
            }
        }
    }
    
    public void flipCol(int[][] grid, int col) {
        int zeros = 0, ones = 0;
        
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][col] == 0) {
                zeros++;
            } else {
                ones++;
            }
        }
        
        if (zeros >= ones) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 0) {
                    grid[row][col] = 1;
                } else {
                    grid[row][col] = 0;
                }
            }
        }
        
    }
}