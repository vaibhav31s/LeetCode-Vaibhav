class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
         boolean[] vis = new boolean[n];
        ArrayList<HashSet<Integer>> alist = new ArrayList<>();
        for(int i = 0; i < n; i++) alist.add(new HashSet<>());
        for(int[] edge : edges){
            alist.get(edge[0]).add(edge[1]);
            alist.get(edge[1]).add(edge[0]);
        }
        int total = 0;
        int count =0;
        outer:
        for(int  i= 0 ; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                Set<Integer> set = new HashSet<>();
                set.add(i);
                dfs(alist, vis, set, i);
                System.out.println(set);
                // if(set.contains(i) && set.contains(i)) count++;
                Integer root = i;
                HashSet<Integer> rootKebacche = alist.get(root);
                int bachhe = rootKebacche.size();
                int good = 0;
                 // System.out.println(bachhe);
                int[] map = new int[n];
                for(int x : rootKebacche){
                    for(int xx :  alist.get(x)){
                        map[xx]++;
                    }
                    map[x]++;
                }
                
                HashSet<Integer> ans = new HashSet<>();
                
                for(int x :  map){
                    if(x == 0 ) continue;
                    if(x != (set.size() - 1)) continue outer;
                }
                // if(ans.size() <= 2) count++;
                // System.out.println(Arrays.toString(map));
                count++;
                // if(good == bachhe) count++;
                
                // if(isContained(i, ))
                }
            
            total++;
        }
        return count;
        
        
    }
    
     void dfs(ArrayList<HashSet<Integer>> alist, boolean[] vis, Set<Integer> set,int node){
        
        for(int x: alist.get(node)){
            if(!vis[x]){
                vis[x]= true;
                set.add(x);
                dfs(alist, vis, set, x);
            }
        }
    }
}