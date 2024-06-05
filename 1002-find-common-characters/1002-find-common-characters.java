class Solution {
    public List<String> commonChars(String[] words) {
        int[] totalFreq = new int[26];
        Arrays.fill(totalFreq, 100);
        for (String s : words) {
            int[] chotamap = new int[26];
            for (char ch : s.toCharArray()) {
                chotamap[ch - 'a']++;
            }
            for (int  i = 0; i < 26; i++) {
                totalFreq[i] = Math.min(chotamap[i], totalFreq[i]);
            }
        }
        List<String> answer = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (totalFreq[ch - 'a'] > 0) {
                for (int i =0; i < totalFreq[ch - 'a']; i++) {
                    answer.add(ch + "");
                }
            }
        }
        return answer;
    }
}