class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> dq = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    dq.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] curCoord = dq.poll();
                for (int[] dir : directions) {
                    int x = curCoord[0] + dir[0];
                    int y = curCoord[1] + dir[1];
                    if (isValidCoord(x, y, n, m, mat)) {
                        dq.add(new int[]{x, y});
                        mat[x][y] = 1 + mat[curCoord[0]][curCoord[1]];
                    }
                }
            }
        }
        
        return mat;
    }
    
    boolean isValidCoord(int x, int y, int n, int m, int[][] mat) {
        if (x < 0 || y < 0 || x >= n || y >= m || mat[x][y] != -1) {
            return false;
        }
        
        return true;
    }
}