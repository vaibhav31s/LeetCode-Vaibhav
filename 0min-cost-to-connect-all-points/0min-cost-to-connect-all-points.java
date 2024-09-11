class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = manhattanDistance(points[i], points[j]);
                edges.add(new int[]{i, j, dist});
            }
        }
        
        List<List<int[]>> alist = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            alist.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], weight = edge[2];
            alist.get(a).add(new int[]{b, weight});
            alist.get(b).add(new int[]{a, weight});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0 ,0});
        boolean[] vis = new boolean[n + 1];
        
        int minSpanningSum = 0;
        while (!pq.isEmpty()) {
            int[] curMinPoint = pq.poll();
            int curPoint = curMinPoint[1];
            int weight = curMinPoint[0];
            
            if (vis[curPoint]) continue;
            
            vis[curPoint] = true;
            minSpanningSum += weight;
            
            for (int[] children : alist.get(curPoint)) {
                int childrenWeight = children[1];
                int childrenValue = children[0];
                pq.add(new int[]{childrenWeight, childrenValue});
            }
            
        }
        
        
        return minSpanningSum;
    }
    
    
    
    
    int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + 
                             Math.abs(a[1] - b[1]);
    }
    
    
   
}
