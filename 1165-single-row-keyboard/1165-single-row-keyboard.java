class Solution {
    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i= 0; i < keyboard.length(); i++){
            map.put(keyboard.charAt(i),i);
            }
        
        int last = 0;
        
        int answer =0;
        for(char ch : word.toCharArray()){
            answer += Math.abs(last - map.get(ch));
            last = map.get(ch);
        }
        return answer;
    }
}