class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        int n = rowSum.length, m = colSum.length;
        
        for (int i = 0; i < n; i++) {
            int expectedRowSum = rowSum[i];
            for (int j = 0; j < m; j++) {
                if (rowSum[i] < colSum[j]) {
                    int max = rowSum[i];
                    rowSum[i] -= max;
                    colSum[j] -= max;
                    ans[i][j] = max;
                } else {
                    int max = colSum[j];
                    rowSum[i] -= max;
                    colSum[j] -= max;
                    ans[i][j] = max;
                }
            }
        }
        return ans;
    }
}

