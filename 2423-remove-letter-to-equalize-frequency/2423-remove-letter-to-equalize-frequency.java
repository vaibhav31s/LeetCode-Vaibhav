class Solution {
    public boolean equalFrequency(String word) {
       HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
           map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
        
            
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            
            if(map.get(ch) == 0 ){
                map.remove(ch);
            }
          
            Set<Integer> values = new HashSet<Integer>();
            for(int val :  map.values()) values.add(val);
            if(values.size() == 1) return true;
            
            
            
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        
        return false;
        
    }
}

// a : 1 b : 1 c : 2
