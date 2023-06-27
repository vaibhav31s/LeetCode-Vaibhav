class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        
        HashSet<String> vis = new HashSet<>();
        
        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> pq = new PriorityQueue<>((a,b)->
             a.getKey()-b.getKey()
        );
        
        pq.add(new Pair(nums1[0]+nums2[0], new Pair(0,0)));
        
        while(k > 0 && !pq.isEmpty()){
            Pair<Integer,Pair<Integer,Integer>> last = pq.poll();
            Pair<Integer,Integer> uv = last.getValue();
            int u = uv.getKey();
            int v = uv.getValue();
            
            String key = u+"--"+v;
            
            if(vis.contains(key)) continue;
            
            List<Integer> ans = new ArrayList<>();
            ans.add(nums1[u]);
            ans.add(nums2[v]);
            
            if(u+1 < nums1.length)
               pq.add(new Pair(nums1[u+1] + nums2[v], new Pair(u+1, v)));
            if(v+1 < nums2.length)
                pq.add(new Pair(nums1[u] + nums2[v+1], new Pair(u, v+1)));
           
            answer.add(ans);
            
            vis.add(key);
            k--;
        }
        
        
        return answer;
    }
}
