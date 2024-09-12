class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        List<Integer> list =new ArrayList<>();
        int streight = grid.length;
        int leftY = streight /  2;
        streight -= leftY;
        int rightY = leftY;
        int ans = 0;
        
        int x = grid.length - 1;
        int y = leftY;
        for (int i =0 ; i < streight; i++) {
            list.add(grid[x--][y]);
        }
        
        x = 0;
        y = 0;
        for (int i =0 ; i < leftY; i++) {
            list.add(grid[x++][y++]);
        }
        
        x = 0;
        y = grid.length - 1;
        for (int i =0 ; i < leftY; i++) {
            list.add(grid[x++][y--]);
        }
        
        int[] map = new int[3];
        for (int[] gr : grid) {
            for (int xx : gr) {
                map[xx]++;
            }
        }
        
        int newSize = grid.length * grid.length - list.size();
        for (int xx : list) map[xx]--;
        
        System.out.println(Arrays.toString(map));
        //if i convert y to 1;
        int count1 = 0;
        for (int xx : list) {
            if (xx != 1) count1++;
        }
        count1 += Math.min(newSize - map[0], newSize -map[2]);
        
        
        int count0 = 0;
        for (int xx : list) {
            if (xx != 0) count0++;
        }
        count0 += Math.min(newSize - map[1], newSize - map[2]);
        
        int count2 = 0;
        for (int xx : list) {
            if (xx != 2) count2++;
        }
        count2 += Math.min(newSize - map[1], newSize -map[0]);
        
        
        return Math.min(count1, Math.min(count2, count0));
    }
}