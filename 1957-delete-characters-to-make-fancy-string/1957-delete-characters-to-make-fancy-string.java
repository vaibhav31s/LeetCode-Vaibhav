class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(new Pair<>(ch, 1));
            } else if (stack.peek().getKey() == ch) {
                int val = stack.peek().getValue();
                stack.pop();
                stack.push(new Pair<>(ch, val + 1));
            } else {
                Pair<Character, Integer> p = stack.peek();
                if (p.getValue() == 1) {
                    sb.append(p.getKey());
                } else {
                    sb.append(p.getKey());
                    sb.append(p.getKey());
                }
                stack.pop();
                stack.push(new Pair<>(ch, 1));
            }
        }
        
        
        if (!stack.isEmpty()) {
            Pair<Character, Integer> p = stack.peek();
            if (p.getValue() == 1) {
                sb.append(p.getKey());
            } else {
                sb.append(p.getKey());
                sb.append(p.getKey());
            }
        }
        
        
        return sb.toString();
    }
}