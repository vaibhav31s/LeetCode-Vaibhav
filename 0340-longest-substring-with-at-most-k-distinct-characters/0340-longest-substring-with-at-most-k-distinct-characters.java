class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k < 1) return k;
        int first = 0;
        int second = 0;
        int max =0;
        int most = k;
        HashMap<Character, Integer> map = new HashMap<>();
        while(first <  s.length()&& second < s.length()){
            char j = s.charAt(second);
            char i = s.charAt(first);
            if(map.size() == most){
                 map.put(j, map.getOrDefault(j, 0)+1);
                second++;
                 if(map.size() > k){
                     map.put(i,map.getOrDefault(i,0)-1);
                    if(map.get(i) == 0) map.remove(i);
                     first++;
                 }
                
            }else
            if(map.size() < most){
                map.put(j, map.getOrDefault(j, 0)+1);
                second++;
            }else{
                map.put(i, map.getOrDefault(i,0)-1);
                if(map.get(i) == 0) map.remove(i);
                                first++;
            }
            max = Math.max(max, second - first );
        }
        return max;
    }
}