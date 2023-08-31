class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = matrix[i][j];
                if (cur == 0) {
                    goVertical(matrix, i, j, n, m);
                    goHorizontal(matrix, i, j, n, m);
                }
            } 
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = matrix[i][j];
                if (cur == (Integer.MIN_VALUE + 33)) {
                    matrix[i][j] = 0;
                }
            } 
        }
        
        
        
    }
    
    void goVertical(int[][] matrix, int i, int j, int n, int m) {
        for( i = 0; i < n; i++) {
            matrix[i][j] = matrix[i][j] != 0 ?  Integer.MIN_VALUE  + 33: 0 ;
            
        }
    }
    
    void goHorizontal(int[][] matrix, int i, int j, int n, int m) {
        for( j = 0; j < m; j++) {
            matrix[i][j] = matrix[i][j] != 0 ? Integer.MIN_VALUE + 33  : 0 ;
        }
    }
}