class Solution {
    public int[][] largestLocal(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] answer = new int[rows - 2][cols - 2];
        
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
               answer[row][col]= findMax(grid, row, col);
            }
        }
        return answer;
    }
    
    int findMax(int[][] grid, int row, int col) {
        int max = 0;
        
        for (int winRow = row; winRow <= row + 2; winRow++) {
            for (int winCol = col; winCol <= col + 2; winCol++) {
                max = Math.max(max, grid[winRow][winCol]);
            }
        }
        return max;
    }
}