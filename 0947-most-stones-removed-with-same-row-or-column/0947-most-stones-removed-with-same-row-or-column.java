class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(50002);
        for(int[] x : stones){
            uf.union(x[0],x[1] + 10001);
        }   
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int[] x :  stones){
            set.add(uf.find(x[0]));
        }
        // System.out.println(uf.root);
        return stones.length - set.size();
    }
}
class UnionFind{
    int[] root;
    int[] rank;
    UnionFind(int size){
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