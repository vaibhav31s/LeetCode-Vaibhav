class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n + 1);
        
        List<int[]> pipess = new ArrayList<>();
        
        
        for (int i = 0; i < n; i++) {
            pipess.add(new int[]{i + 1, 0, wells[i]});
        }
        for (int[] edge : pipes) {
            pipess.add(edge);
        }
        
        Collections.sort(pipess, (a, b) -> a[2] - b[2]);

        for (int[] edge : pipess) {
            uf.union(edge[0], edge[1], edge[2]);
        }
        
        return uf.getSum();
    }
    
    class UnionFind {
        int[] root;
        int[] rank;
        int sum = 0;
        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            
            return root[x]= find(root[x]);
        }
        
        
        void union(int x, int y, int weight) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                } else if (rank[rootY] < rank[rootX]) {
                    root[rootY] = rootX;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                
                sum += weight;
            }
        }
        
        int getSum() {
            return sum;
        }
        
    }
}