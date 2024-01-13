class Solution {
    public int minSteps(String s, String t) {
        int[] first = new int[26];
        int[] second = new int[26];
        for(char ch :  s.toCharArray()) {
            first[ch-'a']++;
        }
        for(char ch :  t.toCharArray()) {
            second[ch-'a']++;
        }
        
        int total = 0;
        for(int i = 0; i < 26; i++) {
            total += Math.abs(first[i] - second[i]);
        }
        
        return total/2;
        
    }
}

// abb aab
// a:1 a:2 1
// a:2 b:1 1

// leetcode practice
// l:1 p:1 2
    
// e:2 e:1 1
//     r:1 1
// o:1 a:1 2
// d:1 c:1 2
    
// t:1 t:1 0
//     i:1 1