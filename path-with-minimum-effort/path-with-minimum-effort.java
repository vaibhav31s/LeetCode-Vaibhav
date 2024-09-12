class Solution {
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[] dist = new int[n * m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int src = 0;
        dist[src] = 0;
        
        int size = n * m;
        
        List<int[]> edges = new ArrayList<>();
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cellLocationIn1d = i * m + j;
                int curValueOfCell = heights[i][j];
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (isValid(x, y, n, m)) {
                        int adjValue = heights[x][y];
                        int adjCellLocationIn1d = x * m + y;
                        int dif = Math.abs(adjValue - curValueOfCell);
                        edges.add(new int[]{cellLocationIn1d, adjCellLocationIn1d, dif});
                    }
                }
            }
        }
        
        for (int i = 0; i <= size + size + 1; i++) {
            boolean isRelaxed = false;
            for (int[] edge : edges) {
                int ui = edge[0];
                int vi = edge[1];
                int maxDif = edge[2];
                
                if (dist[ui] != Integer.MAX_VALUE && Math.max(dist[ui], maxDif) < dist[vi]) {
                    dist[vi] = Math.max(dist[ui], maxDif);
                    isRelaxed = true;
                }
            }
            if (!isRelaxed) {
                break;
            }
        }
        
        System.out.println(Arrays.toString(dist));
        
        return dist[size - 1];
        
    }
    
    boolean isValid(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        
        return true;
    }
}