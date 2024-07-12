class Solution {
    public int maximumGain(String s, int x, int y) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        if (x >= y) {
            for (char ch : s.toCharArray()) {
                if (stack.isEmpty()) stack.push(ch);
                else if (stack.peek() == 'a' && ch == 'b') {
                    stack.pop();
                    answer += x;
                } else stack.push(ch);
            }
            
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) sb.append(ch);
            stack = new Stack<>();
            for (char ch : sb.toString().toCharArray()) {
                if (stack.isEmpty()) stack.push(ch);
                else if (stack.peek() == 'b' && ch == 'a') {
                    stack.pop();
                    answer += y;
                } else stack.push(ch);
            }
            
        } else {
            for (char ch : s.toCharArray()) {
                if (stack.isEmpty()) stack.push(ch);
                else if (stack.peek() == 'b' && ch == 'a') {
                    stack.pop();
                    answer += y;
                } else stack.push(ch);
            }
            StringBuilder sb = new StringBuilder();
            
            for (char ch : stack) sb.append(ch);
            stack = new Stack<>();
            for (char ch :  sb.toString().toCharArray()) {
                if (stack.isEmpty()) stack.push(ch);
                else if (stack.peek() == 'a' && ch == 'b') {
                    stack.pop();
                    answer += x;
                } else stack.push(ch);
            }
        }
        
        return answer;
    }
}