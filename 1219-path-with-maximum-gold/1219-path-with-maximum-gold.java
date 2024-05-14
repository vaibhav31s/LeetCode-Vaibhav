class Solution {
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int max = 0;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    max = Math.max(getMaxGold(grid, row, col), max);            
                }
            }
        }
        return max;
    }
    
    int getMaxGold(int[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        if (row >= rows || col >= cols || row < 0 || col < 0 || grid[row][col] == 0) {
            return 0;
        }
        
        int max = 0;
        int curGoldVal = grid[row][col];
        grid[row][col] = 0;
        
        max = Math.max(curGoldVal + getMaxGold(grid, row + 1, col), max);
        max = Math.max(curGoldVal + getMaxGold(grid, row, col + 1), max);
        max = Math.max(curGoldVal + getMaxGold(grid, row - 1, col), max);
        max = Math.max(curGoldVal + getMaxGold(grid, row, col - 1), max);
        grid[row][col] = curGoldVal;
        return max;
    }
}