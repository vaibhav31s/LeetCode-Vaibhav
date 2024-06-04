class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 0;
        boolean isOddTaken = false;
        
        for (char ch : s.toCharArray()) 
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        for (int freq : map.values()) {
            if (freq % 2 == 1 && !isOddTaken) {
                answer += freq;
                isOddTaken = true;
            } else {
                answer += freq % 2 == 1 ? freq - 1 : freq;
            }
        }
        
        return answer;
    }
}