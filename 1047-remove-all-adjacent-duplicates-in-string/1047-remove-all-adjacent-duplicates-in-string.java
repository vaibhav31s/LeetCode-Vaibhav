class Solution {
    public String removeDuplicates(String s) {
     
        Stack<Character>  stack = new Stack<>();
        for(char c  : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else if(stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder  str = new StringBuilder();
        while(!stack.isEmpty()){
           
            char c = stack.get(0);
            str.append(c);
            stack.remove(0);
        }
        return str.toString();
    }
}