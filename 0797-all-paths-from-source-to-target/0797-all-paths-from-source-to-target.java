class Solution {
    List<List<Integer>> answer= new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(0);
        dfs(graph, 0, graph.length-1,new HashSet<>(), set);
        return answer;
    }
    
    void dfs(int[][] graph, int ind, int end, HashSet<Integer> vis, LinkedHashSet<Integer> list){
        if(ind == end){
            list.add(end);
            answer.add(new ArrayList<>(list));
            return;
        }
        
        // System.out.println(list);
        for(int node : graph[ind]){
            if(!vis.contains(node)){
                list.add(node);
                vis.add(node);
                dfs(graph, node, end,vis,list);
                list.remove(node);
                vis.remove(node);
            }
            
        }
    }
}