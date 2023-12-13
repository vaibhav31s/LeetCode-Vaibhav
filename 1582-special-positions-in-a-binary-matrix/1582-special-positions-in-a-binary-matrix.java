class Solution {
    public int numSpecial(int[][] mat) {
        int answer = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    boolean check = check(mat, i, j);
                    if (check) answer++;
                }
            }
        }
        return answer;
    }
    
    boolean check(int[][] mat, int ii, int jj) {
        int count = 0;
        for(int i = 0; i < mat.length; i++) {
            if(mat[i][jj] == 1) count++;
        }
        
        for(int i = 0; i < mat[ii].length; i++) {
            if(mat[ii][i] == 1) count++;
        }
        return count == 2;
    }
}