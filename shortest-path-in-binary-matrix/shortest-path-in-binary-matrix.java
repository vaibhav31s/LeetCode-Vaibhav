class Solution {
    int[][] directions = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, { 1, -1}, {-1, 1},{-1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int count = 1;
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{0, 0});
        HashSet<Pair<Integer, Integer>> vis = new HashSet<>();
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] lastCoord = dq.poll();
                Pair<Integer, Integer> pair = new Pair<>(lastCoord[0], lastCoord[1]);
                if (vis.contains(pair)) continue;
                vis.add(pair);
                if (lastCoord[0] == n - 1 && lastCoord[1] == n - 1) {
                    return count;
                }
                for (int[] dir : directions) {
                    int x = lastCoord[0] + dir[0];
                    int y = lastCoord[1] + dir[1];
                    if (isValidCoordinate(x, y, n, grid)) {
                        dq.add(new int[]{x, y});
                    }
                }
            }
            count++;
        }
     return -1;   
    }
        
    boolean isValidCoordinate(int x, int y, int n, int[][] grid) {
        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1) return false;

        return true;
    }
}