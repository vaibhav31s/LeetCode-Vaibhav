class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // int[][] g = uni(n, edges[0], edges[1]);
        int[] from = new int[edges.length];
		int[] to = new int[edges.length];
			for(int i = 0;i < edges.length;i++){
				from[i] = edges[i][0] ;
				to[i] = edges[i][1];
			}
        
        int[][] g = uni(n, from, to);
        int answer =0;
        
        // for(int[] ar : g){
        //     System.out.println(Arrays.toString(ar));
        // }
        
   int ans =   dfs(g, 0,hasApple) - 2;
    if(ans < 0) return 0;
        
        return ans;
    }
    
    int dfs(int[][] g, int ind,List<Boolean> has ){
        if(set.contains(ind)) return 0;
        set.add(ind);
//         if(g[ind].length == 1 && has.get(ind)) return 2;
        
//         if(g[ind].length == 1 && !has.get(ind)) return 0;
        
        int ans = 0;
        for(int x : g[ind]){
            ans += dfs(g, x,has);
        }
        
        if(ans != 0){
            return ans +  2;
        }
        return ans + (has.get(ind) ? 2 : 0);
        
    }
    
    public int[][] uni(int n, int[] from, int[] to) {
			return uni(n, from, to, from.length);
		}
    
    public int[][] uni(int n, int[] from, int[] to, int sup) {
			int[][] g = new int[n][];
			int[] p = new int[n];
			for (int i = 0; i < sup; i++) p[from[i]]++;
			for (int i = 0; i < sup; i++) p[to[i]]++;
			for (int i = 0; i < n; i++) g[i] = new int[p[i]];
			for (int i = 0; i < sup; i++) {
				g[from[i]][--p[from[i]]] = to[i];
				g[to[i]][--p[to[i]]] = from[i];
			}
			return g;
		}

}