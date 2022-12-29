/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    int answer;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int n = binaryMatrix.dimensions().get(0) - 1;
        int m = binaryMatrix.dimensions().get(1) -1;
        answer  = m;
        boolean isAnswer =false;
        while(n >= 0 && m >=0){
            if(binaryMatrix.get(n,m) == 1){
                answer = Math.min(m, answer );
                m -= 1;
                isAnswer = true;
            }else{
                n -= 1;
            }
        }
            
        return isAnswer ? answer : -1;
    }
}