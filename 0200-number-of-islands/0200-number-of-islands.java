class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    go(grid, i, j, n, m);
                    answer++;
                }
            }
        }
        return answer;
    }
    void go(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') return;
        grid[i][j] = '0';
        go(grid, i + 1, j, n, m);
        go(grid, i, j -1, n, m);
        go(grid, i - 1, j, n, m);
        go(grid, i, j + 1, n, m);
    }
}