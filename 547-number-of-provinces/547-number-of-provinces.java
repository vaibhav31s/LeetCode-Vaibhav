class Solution {
    public int findCircleNum(int[][] is) {
        
        UnionFind uf = new UnionFind(is.length);
        for(int i = 0 ; i < is.length;i++){
            for(int j = 0; j < is[i].length; j++){
                if(is[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < uf.root.length; i++){
            set.add(uf.root[i]);
        }
        
        return set.size();
    }
    
}
class UnionFind{
    int[] root;
    int[] rank;
    UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    int find(int x){
        if(root[x] ==x) return x;
        return root[x] = find(root[x]);
    }
    
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            for(int i =0 ; i < root.length; i++){
                if(root[i] == rootY){
                    root[i] = rootX;
                }
            }
        }
    }
}