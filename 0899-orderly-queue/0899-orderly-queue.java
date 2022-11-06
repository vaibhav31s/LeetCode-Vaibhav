class Solution {
    public String orderlyQueue(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String answer = s ;
        Deque<Character> dq = new LinkedList<>();
        for(char ch : s.toCharArray()){
            dq.add(ch);
        }
//        dq.remove('c');
        // System.out.println(dq);
        int i = 0;
        if(k >= 2){
            char[] arr= s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
//        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)-> b- a);
        while(i++ < 1000){
            // System.out.println(dq);
            char c = 'a'-2;
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < k; j++){
                char b = dq.pollFirst();
                c = (char)(Math.max(c,b));
                stack.add(b);
            }
            // System.out.println(c);
            while(!stack.isEmpty()){
                if(c == stack.peek()){
                    c= 'z' -11;
                    dq.addLast(stack.pop());
                }else {
                    dq.addFirst(stack.pop());
                }
            }
//            System.out.println(dq);
            sb = new StringBuilder();
            for(char x :  dq) sb.append(x);
            String sbb = sb.toString();
            if(answer.compareTo(sbb) > 0){
                answer = sbb;
            }
            // System.out.println(sb.toString());
        }
        return answer;
    }
}