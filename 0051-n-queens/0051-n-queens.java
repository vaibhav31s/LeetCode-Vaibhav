class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> answer = new ArrayList<>();
        
        for(int i =0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        } //making board full of dots
        
        backtrack(board, 0, 0, answer);
        
        return answer;
        
    }
    
   void backtrack(char[][] board, int i, int j, List<List<String>> answer) {
        
        
        if(i == board.length){
            List<String> list = new ArrayList<>();
            for(int a = 0; a < i; a++){
                list.add(String.valueOf(board[a]));
            }
            answer.add(list);
            return;
        }
        
        if(i >= board.length || j >= board.length || i < 0 || j < 0) return;
       
       for(int col = 0; col < board.length; col++){
            if(isGood(i, col, board)){
                board[i][col] ='Q';
                backtrack(board, i + 1,col , answer);
                board[i][col] = '.';
            }
       }
      
       
        
        
    }
    
    
    boolean isGood(int row, int col, char[][] board){
        
        int duprow = row;
        int dupcol = col;
        while(row >= 0 && col >=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = duprow;
        col =  dupcol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = duprow;
        col =  dupcol;
        while(col >= 0 && row < board.length){
            if(board[row][col]=='Q') return false;
            col--;
            row++;
        }
        
        row = duprow;
        col =  dupcol;
        //four directions
        for(int i = row; i >= 0; i-- ) if(board[i][col] == 'Q') return false;
       for(int i = row; i < board.length; i++ ) if(board[i][col] == 'Q') return false;
       for(int i = col; i >= 0; i-- ) if(board[row][i] == 'Q') return false;
       for(int i = col; i < board.length; i++ ) if(board[row][i] == 'Q') return false;
         int n = board.length;
       while(col < n && row >= 0){
           if(board[row][col]=='Q') return false;
           col++;
           row--;
       }
        //right up
        // while(col <=)
        
        
        return true;
    
        
    }
    
}