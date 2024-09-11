class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> alist = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            alist.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            alist.get(a).add(b);
        }
        
        
        return go(alist, source, destination, new Boolean[n]);
    }
    
   
   boolean go(List<List<Integer>> alist, int cur, int destination, Boolean[] dp) {
        
        if (dp[cur] != null) return dp[cur];
       
        if (alist.get(cur).isEmpty()) {
            return cur == destination;
        }
        dp[cur] = false;
        for (int node : alist.get(cur)) {
            if (!go(alist, node, destination, dp)) {
                return false;
            }
        }
        dp[cur] = true;
        return true;
    }
    

}