class Solution {
    int answer = 0;
    public int maxScoreWords(String[] words, char[] letter, int[] score) {
        int[] letters = new int[26];
        for (char ch : letter) letters[ch - 'a']++;
        go(words, 0, letters, score, new HashSet<>(), 0);
        return answer;
    }
    void go(String[] words, int index, int[]  letters, int[] score, HashSet<Integer> vis, int curScore) {
        answer = Math.max(answer, curScore);
        if (index >= words.length) return;
        if (isZeroScore(score)) return;
        
        for (int i = index; i < words.length; i++) {
            if (vis.contains(i)) continue;
            
            
            if (possibleToReduce(words[i], letters)) {
                // System.out.println("YES" +  words[i]);
                int[] az = new int[26];
                vis.add(i);
                for (char ch : words[i].toCharArray()) {
                    int ind = ch - 'a';
                    letters[ind]--;
                    curScore += score[ind];
                } 
                go(words, i + 1, letters, score, vis, curScore);
                for (char ch : words[i].toCharArray()) {
                    int ind = ch - 'a';
                    letters[ind]++;
                    curScore -= score[ind];
                }
                vis.remove(i); 
            } else {
                 go(words, i + 1, letters, score, vis, curScore);
            }
            
           
        }
    }
    
    boolean possibleToReduce(String s, int[] letters) {
        
        int[] az = new int[26];
        for (char ch : s.toCharArray()) {
            int ind = ch - 'a';
            az[ind]++;
        }
        
        // System.out.println("YES" +  s + Arrays.toString(az) + " " + Arrays.toString(letters));
        
        for (int i = 0; i < 26; i++) {
            if (az[i] == letters[i]) continue;
            if (az[i] > letters[i]) return false;
        }
        
        return true;
    }
    
    boolean isZeroScore(int[] score) {
        for (int x : score) if (x != 0) return false;
        return true;
    }
}