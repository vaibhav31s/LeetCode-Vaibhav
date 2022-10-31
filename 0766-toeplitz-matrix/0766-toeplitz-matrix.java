class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j <  n; j++){
                map.putIfAbsent(i-j, matrix[i][j]);
                if(map.get(i-j) != matrix[i][j]) return false;
            }
        }
        
        return true;
    }
}

// 00 01 02 03
// 10 11 12 13
// 20 21 22 23
