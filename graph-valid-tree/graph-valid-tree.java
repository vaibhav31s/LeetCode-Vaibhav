class Solution {
    public boolean validTree(int n, int[][] edges) {
         if (edges.length != n - 1) return false;
        unionFind u = new unionFind(n);
        for(int[] ed :edges){
            int x =  ed[0];
            int y = ed[1];
            if(!u.union(x,y))return false;
            
        }
        return true;
    }
    class unionFind{
        int[] root ;
        int[] rank;
        unionFind(int size){
            
            root = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }
        int find(int x){
            if(root[x] == x) return x;
            return root[x] = find(root[x]);
        }
        boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            int rankX = rank[rootX];
            int rankY = rank[rootY];
            
             if (rootX == rootY) 
                    return false;
            if(rankX >  rankY){
                root[rootY] = rootX;
            }else if(rankX < rankY){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
    
            return true;
        }
    }
}