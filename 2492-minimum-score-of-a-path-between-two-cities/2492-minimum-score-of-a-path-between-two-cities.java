class Solution {
    public int minScore(int n, int[][] roads) {
      UnionFind  uf = new UnionFind(n+1);
      for(int i= 0; i < roads.length; i++){
          uf.union(roads[i][0], roads[i][1]);
      }  
         int min = Integer.MAX_VALUE;
        for(int[] arr :  roads){
            if(uf.connected(n, arr[0])){
                min = Math.min(arr[2], min);
            }
        }
        
        return min;
    }
    
}
class UnionFind {
     int[] root;
   
     int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;  rank[i] = 1;
        }
    }


    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}