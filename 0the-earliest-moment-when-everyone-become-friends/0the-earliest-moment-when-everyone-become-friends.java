class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        UnionFind uf = new UnionFind(n);
        for (int[] log : logs) {
            if (uf.union(log[1], log[2])) {
                return log[0];
            }
        }
        
        return -1;
    }
    
    class UnionFind {
        int[] root;
        int[] rank;
        int count;
        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            count = size;
        }
        
        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            
            return root[x] = find(root[x]);
        }
        
        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            
            if (rootX != rootY) {
                
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
           
            return count == 1;
        }
    }
}