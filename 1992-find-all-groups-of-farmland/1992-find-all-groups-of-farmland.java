class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[row].length; col++) {
                if (land[row][col] == 1) {
                    int[] coord = new int[4];
                    coord[0] = row;
                    coord[1] = col;
                    go(land, row, col, coord);
                    list.add(coord);
                }
            }
        }
        
        
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
    
    void go(int[][] land, int row, int col, int[] coord) {
        int rows = land.length;
        int cols = land[0].length;
        
        if (row < 0 || col < 0 || row >= rows || col >= cols || land[row][col] == 0) return;
        
        land[row][col] = 0;
        coord[2] = Math.max(coord[2], row);
        coord[3] = Math.max(coord[3], col);
        
        go(land, row + 1, col, coord);
        go(land, row - 1, col, coord);
        go(land, row, col + 1, coord);
        go(land, row, col - 1, coord);
    }
}