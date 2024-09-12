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
        
          for (int i = 0; i < size - 1; i++) { 
            boolean relaxed = false;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1]; // Destination node
                int weight = edge[2]; // Weight of the edge (effort)

                // Relax the edge if possible
                if (dist[u] != Integer.MAX_VALUE && Math.max(dist[u], weight) < dist[v]) {
                    dist[v] = Math.max(dist[u], weight);
                    relaxed = true;
                }
            }
            // If no relaxation happened in this iteration, we can stop early
            if (!relaxed) {
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