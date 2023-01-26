class Solution {
    int answer = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         ArrayList<ArrayList<Pair<Integer,Integer>>> alist = new ArrayList<>();
//         for(int i = 0; i < n; i++) alist.add(new ArrayList<>());
        
//         for(int[] x : flights){
//             int from = x[0];
//             int to = x[1];
//             int price = x[2];
//             alist.get(from).add(new Pair(to,price));
//         }
//         // System.out.println(alist);
        
//         // dfs(alist, src, dst,-1, k,new HashSet<>(),0);
//          int[] dist = new int[n];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         PriorityQueue<Pair<Integer,Integer> > dq = new PriorityQueue<>((a,b)->{
//             return Integer.compare(a.getValue(), b.getValue());
//         });
//         dq.add(new Pair(src,0));
//         while(!dq.isEmpty()){
//             Pair<Integer,Integer> last = dq.poll();
//             for(Pair<Integer,Integer> p :  alist.get(last.getKey())){
//                 if(dist[p.getKey()] >= last.getValue()+p.getValue()){
//                     dist[p.getKey()] = last.getValue() + p.getValue();
//                     dq.add(new Pair(  p.getKey(), last.getValue() + p.getValue()));
//                 }
//             }
            
//         }
        
//         System.out.println(Arrays.toString(dist));
        
        
            
        
        
        
        // return answer == Integer.MAX_VALUE ? -1 : answer;
        
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, src, 0 });

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int dist = temp[0];
            int node = temp[1];
            int steps = temp[2];
            if (steps > stops[node] || steps > k + 1)
                continue;
            stops[node] = steps;
            if (node == dst)
                return dist;
            if (!adj.containsKey(node))
                continue;
            for (int[] a : adj.get(node)) {
                pq.offer(new int[] { dist + a[1], a[0], steps + 1 });
            }
        }
        return -1;
    }
    
    void dfs(ArrayList<ArrayList<Pair<Integer,Integer>>> alist, int cur, int dst,int last, int k, HashSet<Integer> vis,int price){
        if(k < -1) return;
        
        if(cur == dst ){
            answer = Math.min(answer, price);
            // System.out.println(price);
            
            return;
        }
      
            for(Pair<Integer,Integer> p :  alist.get(cur)){
                dfs(alist, p.getKey(),dst,cur, k-1, vis, price+p.getValue());
            }
        
    }
    
}