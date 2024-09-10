class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int size = isConnected.length;
        UnionFind uf = new UnionFind(size);
        
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                } else count++;
            }
            if (count == size) {
                uf.root[i] = -1;
            }
        }
        
       
        return uf.getNoOfIsland();
    }
    
    class UnionFind {
        int[] root;
        int[] rank;
        int count;
        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        //Path compression find function
        int find(int x) { 
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }
        
        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
        int getNoOfIsland() {
            return count;
        }
        
    }
}