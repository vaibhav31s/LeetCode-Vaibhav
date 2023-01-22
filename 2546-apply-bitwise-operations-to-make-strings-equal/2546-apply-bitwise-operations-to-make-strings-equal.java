class Solution {
    public boolean makeStringsEqual(String s, String target) {
        int[] map = new int[2];
        int[] map2 = new int[2];
        for(char ch : s.toCharArray()){
            map[ch-'0']++;
        }
        
        for(char ch : target.toCharArray()){
            map2[ch-'0']++;
        }
        if(s.equals(target)) return true;
        
        return (map[1] >= 1 &&   map2[1]>=1 );

    }
}