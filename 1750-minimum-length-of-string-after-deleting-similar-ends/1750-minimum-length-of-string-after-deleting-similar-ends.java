class Solution {
    public int minimumLength(String s) {
        Deque<Pair<Character, Integer>> dq = new LinkedList<>();
        char cur = s.charAt(0);
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (cur == ch) {
                count++;
            } else {
                dq.add(new Pair(cur, count));
                count = 1;
            }
            cur = ch;
        }
        dq.add(new Pair(cur, count));
        while (dq.size() >= 2) {
            
            Pair<Character, Integer> first = dq.getFirst();
            Pair<Character, Integer> last = dq.getLast();
            if (first.getKey() == last.getKey()) {
                dq.pollFirst();
                dq.pollLast();
            } else {
                break;
            }
        }
        
        int answer = 0;
        if (dq.size() == 1) {
            Pair<Character, Integer> first = dq.getFirst();
            if (first.getValue() == 1) return 1;
            else return 0;
        }
        while (!dq.isEmpty()) {
            answer += dq.pollFirst().getValue();
        }

        return answer;
    }
}