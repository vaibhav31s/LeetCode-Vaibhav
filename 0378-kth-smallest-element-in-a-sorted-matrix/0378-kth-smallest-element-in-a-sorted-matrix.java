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
            int ub = Arrays.binarySearch(mat, mid);
            
            if (ub<0) {
                ub=Math.abs(ub)-1;
            } else {
                int y= mat[ub];
                for(int i= ub + 1; i< mat.length; i++){
                    if (mat[i] == y) 
                        ++ub;
                    else 
                        break;
                 }
             ++ub;
            }
                
            count += ub;
        }
        
        return k <= count;
    }
    
    public int upperbound(int[] mat, int k) {
        int start = 0, end = mat.length - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans = mid;
            }
        }
        return ans + 1;
    }
    
}