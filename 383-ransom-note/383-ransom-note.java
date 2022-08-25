class Solution {
    public boolean canConstruct(String r, String m) {
         HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1= new HashMap<>();
        
        
      for(char ch: m.toCharArray()){
          map.put(ch,map.getOrDefault(ch,0)+1);
      }
        
        for(char ch: r.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        
        int count = 0;
        for(char key : map1.keySet()){
            if(map.containsKey(key) && map1.get(key) <= map.get(key)){
                count++;
            }
            
            
        }
        return count == map1.size();
    }
}