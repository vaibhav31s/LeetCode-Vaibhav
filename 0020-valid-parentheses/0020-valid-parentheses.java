class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }else if(ch == ')'){
                if(!stack.isEmpty() &&  stack.peek() == ')') stack.pop();
                  else return false;
            }else if(ch == '['){
                    stack.push(']');
            }else if(ch == ']'){
                     if(!stack.isEmpty() && stack.peek() == ']') stack.pop();
                     else return false;
            }else if(ch == '{'){
                    stack.push('}');

            }else if (ch == '}'){
                     if(!stack.isEmpty() && stack.peek() == '}') stack.pop();
                       else return false;

            }
        }


        return stack.isEmpty();
    }
}