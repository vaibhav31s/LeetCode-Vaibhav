class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int answer  = -1;
        int extra = 0;
        for(int[] edge : connections){
            int a = edge[0];
            int b = edge[1];
            if(uf.connected(a,b)) extra++;
            
            else uf.union(a,b);
        }
        
        System.out.println(Arrays.toString(uf.root));
        System.out.println(extra);
        
        HashSet<Integer> set = new HashSet<>();
        for(int x : uf.root) set.add(uf.find(x));
        int size = set.size()-1;
        if(size - extra > 0) return -1;
        return size;
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