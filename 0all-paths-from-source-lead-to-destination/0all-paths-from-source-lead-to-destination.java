class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> alist = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            alist.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            alist.get(a).add(b);
        }
        return traverse(alist, source, destination, new Boolean[n]);   
    }
    
    boolean traverse(List<List<Integer>> alist, int node, int dest, Boolean[] state) {
        if (state[node] != null) {
            return state[node];
        }
        
        if (alist.get(node).isEmpty()) {
            return node == dest;
        }
        state[node] = false;
        for (int nod : alist.get(node)) {
            if (!traverse(alist, nod, dest, state)) {
                return false;
            }
        }
        
        return state[node] = true;
    }

}