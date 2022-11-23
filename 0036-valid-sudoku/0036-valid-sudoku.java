class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int row = 0; row < 9; row++){
            HashSet<Character> r = new HashSet<>();            HashSet<Character> c = new HashSet<>();

            for(int col = 0; col < 9; col++){
               char ch = board[row][col];
                char chh = board[col][row];
                if(ch >= '0' && ch <= '9'){
                    if(r.contains(ch)) return false;
                    r.add(ch);
                }
                
                  if(chh >= '0' && chh <= '9'){
                    if(c.contains(chh)) return false;
                      c.add(chh);
                }
                
            }
        }
         for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                 boolean[] set = new boolean[10];
                for(int k = i; k < i+3; k++){
                    for(int l = j; l< j+3; l++){
                        if(board[k][l] != '.'){
                            int index = board[k][l] - '0';
                            if(set[index] == false){
                                set[index] = true;
                            }else 
                                return false;
                        }
                    }
                }
                 
            }
        }
      

            
        
        return true;
        
        
        
    }
}


//  each row mts 1 - 9
/// each column 1to 9
// each 3x3 ox must 1-9