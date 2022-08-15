class Solution {
    public int earliestAcq(int[][] logs, int n) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(logs,(a,b) -> a[0] -b[0]);
        for(int[] x : logs){
            int timestamp = x[0];
            int a = x[1];
            int b = x[2];
            uf.union(a,b);
            Set<Integer> set = new HashSet<>();
            for(int i  = 0; i < n; i++){
                set.add(uf.root[i]);
            }
            if(set.size() == 1) return timestamp;
        }
        return -1;
    }
}
class UnionFind{
    int[] root;
    UnionFind(int size){
        root=  new int[size];
        for(int i = 0; i < size; i++)
            root[i] = i;
    }
    int find(int x){
        if(root[x] == x) return x;
        
        return root[x] = find(root[x]);
    }
    
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
        
    }
}