class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix.length - 1];
        int ans = start;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(matrix, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;    
    }
    
    public boolean check(int[][] matrix, int mid, int k) {
        int count = 0;
        for (int[] mat : matrix) {
            for (int x : mat) {
                if (x <= mid) {
                    count++;
                }
            }
        }
        
        return k <= count;
    }
    
}