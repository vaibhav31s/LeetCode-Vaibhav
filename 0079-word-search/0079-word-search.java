class Solution {
    boolean answer= false;
    public boolean exist(char[][] board, String word) {
        
        for(int i= 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == word.charAt(0)){
                         backtrack(board, word.toCharArray(),i,j, 0);
                        if(answer) return true;
                    }
            }
        }
        return answer;
    }
    
    void backtrack(char[][] board, char[] word, int i, int j, int index){
            if(index >= word.length){
                answer = true;
                return;
            }
            if(i >= board.length ||  j >= board[0].length || i < 0 || j < 0 ) return;
        
            
            char ch = board[i][j];
            if(word[index] != ch) return ; 
            board[i][j] = '.';
            
            backtrack(board, word, i+1, j, index + 1);
            backtrack(board, word, i, j - 1, index + 1);
            backtrack(board, word, i-1, j, index + 1);
            backtrack(board, word, i, j + 1, index + 1);
        
            
        
            board[i][j] = ch;
    }
    
    
}