class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1},  {-1, 0}, {1, 0}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        UnionFind uf = new UnionFind(n * m, grid);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : directions) {
                        int xx = i + dir[0];
                        int yy = j + dir[1];
                        if (isValidCoordinate(grid, xx, yy, n, m)) {
                            uf.union((i * m) + j, (xx * m) + yy);
                        }
                    }
                }
            }
        }
        
        return uf.getCount();
    }
    
    boolean isValidCoordinate(char[][] grid, int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == '0') {
            return false;
        }
        
        return true;
    }
    
    class UnionFind {
        int[] root;
        int[] rank;
        int count = 0;
        
        UnionFind(int size, char[][] grid) {
            
            root = new int[size];
            rank = new int[size];
            
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == '1') {
                            count++;
                            root[i * grid[i].length + j ] = i * grid[i].length + j;
                        }
                    rank[i * grid[i].length  + j] = 0;
                }
                
            }
        }
        
        int find(int x) {
            if (x  == root[x]) {
                return x;
            }
            
            return root[x] = find(root[x]);
        }
        
        void union(int x, int y) {
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
                count--;
            }
        }
        int getCount() {
            return count;
        }
    }
}