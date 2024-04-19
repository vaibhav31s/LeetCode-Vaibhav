class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, answer = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    go(grid, i, j, rows, cols);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    void go(char[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') return;
        
        grid[row][col] = '0'; // Mark as visited
        go(grid, row + 1, col, rows, cols);
        go(grid, row, col -1, rows, cols);
        go(grid, row - 1, col, rows, cols);
        go(grid, row, col + 1, rows, cols);
    }
}