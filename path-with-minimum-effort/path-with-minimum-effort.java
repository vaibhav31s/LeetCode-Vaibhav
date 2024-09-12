class Solution {
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
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
        
        List<List<int[]>> alist = new ArrayList<>();
        for (int i = 0; i < size; i++) alist.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int ui = edge[0];
            int vi = edge[1];
            int weight = edge[2];
            alist.get(ui).add(new int[]{vi, weight});
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n * m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int src = 0;
        dist[src] = 0;
        
        pq.add(new int[]{src, 0});
        
        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int node = currNode[0];
            int weight = currNode[1];
            

            for (int[] adjCell : alist.get(node)) {
                int cell = adjCell[0];
                int value = adjCell[1];
                
                if (dist[cell] > Math.max(weight, value)) {
                    dist[cell] = Math.max(weight, value);
                    pq.add(new int[]{cell, Math.max(weight, value)});
                }
            }
            
        }
        
        return dist[size - 1];
        
    }
    
    boolean isValid(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        
        return true;
    }
}