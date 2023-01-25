class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist = new int[edges.length];
         int[] dist2 = new int[edges.length];
        
        for(int i = 0; i < dist.length; i++){
            dist[i] = -1;
            dist2[i] = -1;
        }
        List<Pair<Integer,Integer>> first = new ArrayList<>();
        List<Pair<Integer,Integer>> second = new ArrayList<>();
        
        dfs(edges, first,node1, 0, new HashSet<>());
        // dfs(edges, first,node2, new HashSet<>());
        dfs(edges, second,node2, 0, new HashSet<>());
        for(int i = 0;i < first.size(); i++){
            dist[first.get(i).getKey()] =  first.get(i).getValue();
        }
        for(int i = 0;i < second.size(); i++){
            dist2[second.get(i).getKey()] =  second.get(i).getValue();
        }
        
        
//         System.out.println(Arrays.toString(dist));
//         System.out.println(Arrays.toString(dist2));
        
        int min=Integer.MAX_VALUE,node=-1;
        for(int i=0;i<edges.length;i++){
            if(dist[i]!=-1 && dist2[i]!=-1){
                int t=Math.max(dist[i],dist2[i]);
                if(min>t){
                    min=t;
                    node=i;
                }
                else if(min==t) node=Math.min(node,i);
            }
        }
        return node;
        
    }
    
    void dfs(int[] edges, List<Pair<Integer,Integer>> first, int cur, int deep, HashSet<Integer> set){
        if(cur == -1) return;
        if(!set.contains(cur)){
            set.add(cur);
            first.add(new Pair<>(cur, deep));
            dfs(edges,first,edges[cur], deep+1,set);
        }
        
    }
}