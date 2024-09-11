class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int rows = grid.length; 
        int cols = grid[0].length;
        
        Deque<int[]> dq = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    dq.add(new int[]{i, j});
                } 
            }
        }
        
        if (dq.isEmpty()) {
             if (anyFreshOranges(grid)) {
            return -1;
        }
            return 0;}
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] currentRottenOrange = dq.poll();
                
                for (int[] dir : directions) {
                    int x = currentRottenOrange[0] + dir[0];
                    int y = currentRottenOrange[1] + dir[1];
                    if (isValidOrangeThere(x, y, grid)) {
                        dq.add(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            minutes++;
        }
         if (anyFreshOranges(grid)) {
            return -1;
        }
       
        return minutes - 1;
    }
    
    boolean isValidOrangeThere(int x, int y, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 || grid[x][y] == 2) {
            return false;
        } 
        return true;
    }
    
    boolean anyFreshOranges(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}