class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        for(int i = 0; i < n; i++) alist.add(new ArrayList<>());
        for(int[] edge : edges){
            alist.get(edge[0]).add(edge[1]);
            alist.get(edge[1]).add(edge[0]);
        }
        for(int  i= 0 ; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                Set<Integer> set = new HashSet<>();
                set.add(i);
                dfs(alist, vis, set, i);
                System.out.println(set);
                if(set.contains(source) && set.contains(destination)) return true;
                }
        }
        
        return false;
    }
    void dfs(ArrayList<ArrayList<Integer>> alist, boolean[] vis, Set<Integer> set,int node){
        
        for(int x: alist.get(node)){
            if(!vis[x]){
                vis[x]= true;
                set.add(x);
                dfs(alist, vis, set, x);
            }
        }
    }
}