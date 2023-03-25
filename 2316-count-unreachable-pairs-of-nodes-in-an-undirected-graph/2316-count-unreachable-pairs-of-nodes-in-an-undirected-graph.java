class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}
class Solution {
    public long countPairs(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int e = edges.length;
        for(int i = 0; i<e; i++){
            ds.unionByRank(edges[i][0], edges[i][1]);
        }
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(ds.findUPar(i), map.getOrDefault(ds.findUPar(i),0)+1);
        }
        // System.out.println(map);
        for(int i = 0; i<n; i++){
            sum += (n-map.get(ds.findUPar(i)));
        }
        return sum/2;
    }
}