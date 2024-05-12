class Solution {
    public int[][] largestLocal(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int[][] answer = new int[rows - 2][cols - 2];
        for (int row = 0; row < rows - 2; row++) {
            int[] cur = new int[cols - 2];
            for (int col = 0; col < cols - 2; col++) {
                int max = 0;
                for (int winRow = row; winRow <= row + 2; winRow++) {
                    for (int winCol = col; winCol <= col + 2; winCol++) {
                        max = Math.max(max, grid[winRow][winCol]);
                    }
                }  
                cur[col] = max;
            }
           answer[row] = cur;   
        }
        
        return answer;
    }
}