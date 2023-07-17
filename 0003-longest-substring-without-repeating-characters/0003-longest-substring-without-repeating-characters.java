class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>();
        int first = 0;
        int second = 1;
        if(s.length() <= 1) return s.length();
        map.add(s.charAt(0));
        int answer = 0;
        while(second < s.length()){
            
            if(map.contains(s.charAt(second))){
                
                 while(!map.contains(s.charAt(first))){
                     map.remove(s.charAt(first));
                     first++;
                 }
                   map.remove(s.charAt(first));
                    first++;
            }else{
                map.add(s.charAt(second++));
            }
               
            answer = Math.max(answer, second - first);
            
        }
               return answer;
    }
}

// pwwkew
