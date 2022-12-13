class Solution {
    HashMap<String , Integer>map = new HashMap<>();
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for(int i= 0; i < r; i++){
           min = Math.min(dfs(matrix, 0, i, r) ,min);
        }
        
        return min;
    }
    
    
    int dfs(int[][] matrix, int r, int c, int rc){
         if (c < 0 || c == matrix.length) {
            return Integer.MAX_VALUE;
        }
        if(r == rc - 1) return matrix[r][c];
        String k = r + ","+ c;
        if(map.containsKey(k)) return map.get(k);
        int left = dfs(matrix,r +1, c , rc);
        int center = dfs(matrix,r +1, c + 1 , rc);
        int right = dfs(matrix,r +1, c - 1, rc) ;
        
        map.put(k,Math.min(left, Math.min(center, right)) +  matrix[r][c]) ;
        return map.get(k);
    }
}