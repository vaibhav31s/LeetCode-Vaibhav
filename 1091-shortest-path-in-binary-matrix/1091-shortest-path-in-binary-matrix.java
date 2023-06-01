class Solution {
    public int shortestPathBinaryMatrix(int[][] arr) {
           int n = arr.length;
        if(arr[0][0] == 1 || arr[n-1][n-1] == 1) return -1;
        if(n == 1) return 1;
        
        int dir[][] = {{-1, 0},{1, 0},{0,-1},{0,1},{-1,-1},{1,-1},{-1,1},{1,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        
        while(! queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                if(curr[0] == n-1 && curr[1] == n-1){
                    return curr[2];
                }
                
                for(int it[] : dir){
                    
                    int row = curr[0]+it[0];
                    int col = curr[1]+it[1];
                    
                    if(row>=0 && col>=0 && row<n && col<n && arr[row][col] == 0){
                        queue.add(new int[]{row, col, curr[2]+1});
                        arr[row][col] = 1;
                    }
                }
                arr[curr[0]][curr[1]] = 1;
            }
        }
        
        return -1;
    }
}