class Solution {
    // HashSet<String> vis = new HashSet<>();
    HashMap<String, Integer> map = new HashMap<>();
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return go(obstacleGrid, 0,0, obstacleGrid.length, obstacleGrid[0].length);
    }
    int go(int[][] grid, int i, int j, int n, int m ){
        if(i >= n || j >= m || grid[i][j] == 1)return 0;
        if(n - 1 == i && m - 1== j) return 1;
        String k = i + "-" + j;
        if(map.containsKey(k) ) return map.get(k);
        map.put(k,go(grid, i, j + 1, n, m) + go(grid, i +1 , j, n , m) );
        return map.get(k);
        
    }
}