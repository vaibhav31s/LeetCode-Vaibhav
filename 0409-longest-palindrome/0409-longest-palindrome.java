class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int answer = 0;
        boolean isOddTaken = false;
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() % 2 == 1 && !isOddTaken) {
                answer += kv.getValue();
                isOddTaken = true;
            } else {
                answer += kv.getValue() % 2 == 1 ? kv.getValue() - 1 : kv.getValue();
            }
        }
        
        return answer;
    }
}