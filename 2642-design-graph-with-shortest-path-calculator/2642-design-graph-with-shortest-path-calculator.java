class Graph {
  
    List<List<Pair<Integer, Integer>>> alist;
    int n = 0;
    public Graph(int n, int[][] edges) {
        
        this.n = n;
        alist = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            alist.add(new ArrayList<>());
        }
        
        for (int[] edge :  edges) {
            alist.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
    }
    
    public void addEdge(int[] edge) {
        alist.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[node1] = 0;
        int totalSum  = 0;
        PriorityQueue<Pair<Integer, Integer>> dq = new PriorityQueue<>((a,b)->{
            return a.getValue() - b.getValue();
        });
        dq.add(new Pair(node1, 0));
        while(!dq.isEmpty()) {
            
        // System.out.println(vis);
            
            Pair<Integer, Integer> curPair = dq.poll();
            
            int curPairVal = curPair.getKey();
            int curWeight = curPair.getValue();
            
            for (Pair<Integer, Integer> pair :  alist.get(curPairVal)) {
                int pairVal = pair.getKey();
                int pairWeight = pair.getValue();
                
                
                
                if(curWeight + pairWeight >= weight[pairVal]) continue;
                else weight[pairVal] = curWeight + pairWeight;
                
                
                dq.add(new Pair(pairVal, curWeight + pairWeight));
                
                
            }
            
           
        }
        
        if(weight[node2] != Integer.MAX_VALUE) return weight[node2];
        System.out.println(Arrays.toString(weight));
        
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */