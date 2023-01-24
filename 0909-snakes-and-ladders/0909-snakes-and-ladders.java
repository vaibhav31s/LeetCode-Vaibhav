class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int n2 = n * n;
        int[] arr = new int[n2+1];
        boolean flag =  true;
        int a = 1;
        for(int i =n-1; i >= 0; i--){
            if(flag){
                for(int j= 0; j < n; j++){
                    arr[a++] = board[i][j];
                }
            }else{
              for(int j= n-1; j >= 0 ; j--){
                    arr[a++] = board[i][j];
               } 
            }
            flag = !flag;
        }
        int answer = 0;
        if(board[0][0] != -1) return -1;
        HashMap<Integer,Integer> set = new HashMap<>();
        Deque<Integer> dq = new LinkedList<>();
        HashSet<Integer> s = new HashSet<>();
        dq.add(1);
        while(!dq.isEmpty()){
             
            int nn = dq.size();
            while(nn-- > 0 ){
                int curr = dq.poll();
                if(curr == n * n) return answer;
            
                for(int i = 1; i <= 6; i++){
                    
                    int aa=   Math.min(curr + i, n*n);
                    
                    if(arr[aa] == -1){    
                        if(s.contains(aa)) continue;
                        s.add(aa);
                        dq.add(aa);
                    }
                    else{
                        
                        if(s.contains(arr[aa])) continue;
                        dq.add(arr[aa]);
                        
                        s.add(arr[aa]);
                          
                        
                    }
                    
                }
            }
           answer++;
        }
        
        
        return -1;
        
    }
}