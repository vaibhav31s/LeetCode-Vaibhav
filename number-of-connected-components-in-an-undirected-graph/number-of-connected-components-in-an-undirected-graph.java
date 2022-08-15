class Solution {
    public int countComponents(int n, int[][] edges) {
        unionFind uf = new unionFind(n);
        Set<Integer> set = new LinkedHashSet<>();
        for(int[] ed : edges){
            uf.union(ed[0],ed[1]);
           
        }
        Set<Integer> set1 = new HashSet<>();
        for(int i = 1; i <= n; i++){
            set1.add(uf.root[i]);
        }
        return set1.size();
    }
    
}
class unionFind{
    int[] root;
    int[] rank;
    unionFind(int size){
        root = new int[size+1];
       
        for(int i = 0; i < size; i++){
            root[i] = i;
   
        }
    }
    int find(int x){
        if(x == root[x]) return x;
        return root[x] = find(root[x]);
    }
    
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        for(int i =0; i < root.length; i++){
                    if(rootY == root[i]){
                            root[i] = rootX;
                    }
        }
    }
}