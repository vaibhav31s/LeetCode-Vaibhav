class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] map = new int[26][2];
        // map[s.charAt(0) - 'a'][0] = 0;
        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(map[ch - 'a'][0] == 0 && s.charAt(0) != ch) {
                map[ch - 'a'][0] = i;
            } else {
                map[ch - 'a'][1] = i;
            }
        }
        int answer = -1;
        for (int i = 0; i < 26; i++) {
            int first = map[i][0];
            int second = map[i][1];
            if(second == 0) continue;
            answer = Math.max(answer, second - first - 1);
        }
        return answer;
    }
}