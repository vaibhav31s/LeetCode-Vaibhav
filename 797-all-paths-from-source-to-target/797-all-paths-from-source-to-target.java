class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
            List<Integer> list = new ArrayList<>();
                list.add(0);
                dfs(graph, vis, answer, list, 0);
               
       
        return answer;
    }
    
    void dfs(int[][] graph, boolean[] vis, List<List<Integer>> answer, List<Integer> list, int node){
        if(list.size() != 0 && list.get(list.size()-1) == graph.length- 1){
            answer.add(new ArrayList<>(list));
        }
        if(!vis[node]){
            for(int x : graph[node]){
                vis[node] =true;
                list.add(x);
                dfs(graph, vis, answer, list, x);
                list.remove(list.size()-1);
                vis[node] = false;
            }
            
        }
        
    }
}