class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() < 2) return false;
        if(s.length() !=  goal.length()) return false;
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> second = new HashMap<>();
        
        
        for(char ch :  s.toCharArray()){
            first.put(ch, first.getOrDefault(ch, 0)+1);
        }
        
        for(char ch :  goal.toCharArray())
            second.put(ch, second.getOrDefault(ch, 0)+1);
        
        if(first.equals(second)){
            
                int count = 0;
            for(int i  = 0; i < s.length(); i++){
                if(s.charAt(i) != goal.charAt(i)) count++;
            }
                if(s.equals(goal) && first.size() == 1) return true;
                if(s.equals(goal) && s.length() > 2 && first.size() != s.length()) return true;
                if(count == 2) return true; 
            
        }
        
        return false;
    }
}