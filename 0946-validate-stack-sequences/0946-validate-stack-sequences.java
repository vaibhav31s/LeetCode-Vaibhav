class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();int i = 0,  j= 0;
        for(; i < pushed.length && j <  pushed.length;  ){
            if(stack.isEmpty()){
                stack.push(pushed[i]);
                i++;
            }else{
                int pPeek = pushed[i];
                int pPopped = popped[j];
                if(stack.peek() == pPopped){
                    j++;
                    stack.pop();
                }else {
                    stack.push(pPeek);
                    i++;
                }
            }
            
            
        }
        while(!stack.isEmpty() && j < pushed.length){
            int a = popped[j];
            if(stack.peek() == a){
                j++;
                stack.pop();
            }else return false;
        }
        return stack.isEmpty();
    }
}