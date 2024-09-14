class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> alist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            alist.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[n];
        
        for (int[] edge : edges) {
            int ui = edge[0];
            int vi = edge[1];
            alist.get(ui).add(vi);
            alist.get(vi).add(ui);
            inDegree[ui]++;
            inDegree[vi]++;
        }
        
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                dq.add(i);
            }
        }
        
        int totalNodes = n;
        while (totalNodes > 2) {
            int size = dq.size();
            while (size-- > 0){
                int curNode = dq.poll();
                totalNodes--;
                inDegree[curNode]--;
                for (int child : alist.get(curNode)) {
                    inDegree[child]--;
                    if (inDegree[child] == 1) {
                        dq.add(child);
                    }
                }
            }
        }
        
        
        System.out.println(Arrays.toString(inDegree));
        
        while(!dq.isEmpty()) {
            ans.add(dq.poll());
        }
        
        if (ans.isEmpty()) ans.add(0);
     
        return ans;
    
        
    }
    
    void getPath(List<List<Integer>> alist, int src, HashSet<Integer> vis, List<Integer> path) {
    
        path.add(src);
        vis.add(src);
        
        for (int child : alist.get(src)) {
                if (vis.contains(child)) continue;
            vis.add(child);
            getPath(alist, child, vis, path);
           
        }
    }
}