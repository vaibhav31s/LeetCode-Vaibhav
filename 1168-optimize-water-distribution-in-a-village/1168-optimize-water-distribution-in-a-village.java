class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int sum = 0;
        
       
        List<List<int[]>> alist = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            alist.add(new ArrayList<>());
        }
        
        for (int[] pipe : pipes) {
            int a = pipe[0];
            int b = pipe[1];
            int weight = pipe[2];
            
            alist.get(a).add(new int[]{b, weight});
            alist.get(b).add(new int[]{a, weight});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < wells.length; ++i) {
            int[] virtualEdge = new int[]{i + 1, wells[i]};
            alist.get(0).add(virtualEdge);
            // initialize the heap with the edges from the virtual vertex.
            pq.add(new int[]{wells[i], i + 1});
        }
        boolean[] vis = new boolean[n + 1];
        
        while (!pq.isEmpty()) {
            int[] minNode = pq.poll();
            int weight = minNode[0];
            int curNode = minNode[1];
            
            if (vis[curNode]) continue;
        
            vis[curNode] = true;
            sum += weight;
            
            for (int[] connectedNodes : alist.get(curNode)) {
                pq.add(new int[]{connectedNodes[1], connectedNodes[0], curNode});
            }
        }
        
        
        return sum;
    }
}