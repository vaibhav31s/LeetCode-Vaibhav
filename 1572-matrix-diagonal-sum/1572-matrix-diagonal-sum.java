class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int p = mat.length;
        int sum = 0;
        for(int i = 0; i < n; i++)
             sum += mat[i][--p];
        
        for(int i = 0; i < n; i++)
             sum += mat[i][i];
        
        if(n % 2 == 1 ) sum -= mat[n/2][n/2];
        return sum;
    }
}


