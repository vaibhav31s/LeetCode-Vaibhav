class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        return multiply1(mat1, mat2);
    }
    
        public static int[][] multiply1(int[][] left, int[][] right) {
        int MOD = 1000000007;
        int N = left.length;
        int M = right[0].length;
        int[][] res = new int[N][M];
        for (int a = 0; a < N; a++)
            for (int b = 0; b < M; b++)
                for (int c = 0; c < left[0].length; c++) {
                    res[a][b] += (left[a][c] * right[c][b]) % MOD;
                    if (res[a][b] >= MOD)
                        res[a][b] -= MOD;
                }
        return res;
    }
}