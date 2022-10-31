class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j <  n; j++){
               if(matrix[i-1][j-1] != matrix[i][j]) return false;
            }
        }
        
        return true;
    }
}

// 00 01 02 03
// 10 11 12 13
// 20 21 22 23
