class Solution {
    HashSet<Integer> set = new HashSet<>();
    int[] ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[][] graph = packU(n, edges);
        ans = new int[n];
        
    int[] arr= dfs(graph, labels.toCharArray(), 0, -1);
        return ans;
    }
     
    int[] dfs(int[][] g, char[] label, int ind, int last){
        int[] map = new int[26];
        if(set.contains(ind)) return map;
        set.add(ind);
        int index = label[ind] - 'a';
        map[index]++;
        
        for(int x:  g[ind]){
            if(!set.contains(x)){
                int[] arr = dfs(g, label, x, ind);
                for(int i = 0; i < 26; i++){
                    map[i] += arr[i];
                }
            }
        }
        
        ans[ind] = map[index];
        
        
        return map;
    }
  

    public int[][] packU(int n, int[][] ft) {
        int[][] g = new int[n][]; int[] p = new int[n];
        for(int[] u : ft){ p[u[0]]++; p[u[1]]++; } 
        for(int i = 0;i < n;i++)g[i] = new int[p[i]]; 
        for(int[] u : ft){ g[u[0]][--p[u[0]]] = u[1]; g[u[1]][--p[u[1]]] = u[0]; } 
        return g;
    }
}