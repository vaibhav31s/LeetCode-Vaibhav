class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                Stack<Character> insideBrackets = new Stack<>();
                while (stack.peek() != '(') {
                    insideBrackets.push(stack.pop());
                }
                stack.pop();
                for (char x : insideBrackets) stack.push(x);
                continue;
            }
            
            stack.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char x : stack) {
            sb.append(x);
        }
    return sb.toString();
    }
}