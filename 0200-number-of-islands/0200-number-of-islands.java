class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1},  {-1, 0}, {1, 0}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    BFS(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void BFS(char[][] grid, int i, int j) {
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{i, j});
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] coord = dq.poll();
                for (int[] dir : directions) {
                    int x = dir[0] + coord[0];
                    int y = dir[1] + coord[1];
                    if (isValidCoordinate(grid, x, y, grid.length, grid[0].length)) {
                        dq.add(new int[]{x, y});
                        grid[x][y] = '0';
                    }
                }
            }
        }
    }
    
    boolean isValidCoordinate(char[][] grid, int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == '0') {
            return false;
        }
        
        return true;
    }
}