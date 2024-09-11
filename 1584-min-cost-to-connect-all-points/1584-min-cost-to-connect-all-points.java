class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = manhattanDistance(points[i], points[j]);
                edges.add(new int[]{i, j, dist});
            }
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }
        return uf.getSum();
    }
    
    int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + 
                             Math.abs(a[1] - b[1]);
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
            return root[x] = find(root[x]);
        }
        
        void union(int x, int y, int weight) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
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

//  // class UnionFind {
//         HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>> root;
//         HashMap<Pair<Integer, Integer>, Integer> rank;
//         int sum = 0;
//         UnionFind(int[][] points) {
//             root = new HashMap<>();
//             rank = new HashMap<>();
//             for (int[] point : points) {
//                 Pair<Integer, Integer> pair = new Pair<>(point[0], point[1]);
//                 root.put(pair, pair);
//                 rank.put(pair, 1);
//             }
//         }
        
//         Pair<Integer, Integer> find(Pair<Integer, Integer> x) {
//             if (x == root.get(x)) {
//                 return x;
//             }
            
//             root.put(root.get(x), find(root.get(x)));
//             return root.get(x);
//         }
        
//         void union(Pair<Integer, Integer> x, Pair<Integer, Integer> y, int weight) {
//             Pair<Integer, Integer> rootX = find(x);
//             Pair<Integer, Integer> rootY = find(y);
//             if (!rootX.equals(rootY)) {
//                 if (rank.get(rootX) < rank.get(rootY)) {
//                     root.put(rootX, rootY);
//                 } else if (rank.get(rootY) < rank.get(rootX)) {
//                     root.put(rootY, rootX);
//                 } else {
//                     root.put(rootY, rootX);
//                     rank.put(rootX, rank.get(rootX) + 1);
//                 }
//                 sum += weight;
//             }
//         }
        
//         int getSum() {
//             return sum;
//         }
//     }