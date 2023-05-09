class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 ) return new ArrayList<>();
        int firstR = 0;
        int lastR = matrix.length-1;
        int firstC = 0;
        int lastC = matrix[0].length-1;
        
        List<Integer> answer = new ArrayList<>();
        while( firstR <= lastR &&  firstC <= lastC){
            right(matrix[firstR], firstC, lastC, answer);
            firstR++;
            
            down(matrix, lastC, firstR, lastR, answer);
            lastC--;
            if((firstR > lastR)) break;
            left(matrix[lastR], firstC, lastC, answer);
            lastR--;
            if((firstC > lastC)) break;
            up(matrix, firstC, firstR, lastR, answer);
            firstC++;
           
        }
        return answer;
    }
    void right(int[] mat,int firstC, int lastC, List<Integer> answer){
        for(int i = firstC; i <= lastC; i++)
            answer.add(mat[i]);
    }
    
    void down(int[][] mat, int lastC, int firstR, int lastR, List<Integer> answer){
        for(int i = firstR; i <= lastR; i++)
            answer.add(mat[i][lastC]); 
    }
    
    void left(int[] mat, int firstC, int lastC, List<Integer> answer){
        for(int i = lastC; i >= firstC; i--)
            answer.add(mat[i]);
    }
    
    void up(int[][] mat, int firstC, int firstR, int lastR, List<Integer> answer){
        for(int i = lastR; i >= firstR; i--)
            answer.add(mat[i][firstC]);
    }
    
    
}