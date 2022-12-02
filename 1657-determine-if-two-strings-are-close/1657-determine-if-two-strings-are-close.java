class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() > word2.length()) return false;
        if(word1.length() < word2.length()) return false;
        
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : word1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+ 1);
            
        }
        
        TreeMap<Integer,Integer> mapp = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for(char ch :  map.keySet()){
            mapp.put(map.get(ch),mapp.getOrDefault(map.get(ch),0) + 1);
        }
        // System.out.println(mapp);
        
        
         HashMap<Character, Integer> map1 = new HashMap<>();
        for(char ch : word2.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+ 1);
            
        }
        
        TreeMap<Integer,Integer> mapp1 = new TreeMap<>();
        StringBuilder sb1 = new StringBuilder();
        for(char ch :  map1.keySet()){
            mapp1.put(map1.get(ch),mapp1.getOrDefault(map1.get(ch),0) + 1);
        }
        // System.out.println(mapp1);
         if (!map.keySet().equals(map1.keySet())) {
            return false;
        }
        
        for(Integer ch :  mapp1.keySet()){
           if(!mapp.containsKey(ch)) return false;
            if(mapp.get(ch) != mapp1.get(ch))return false;
        }
        return true;
    }
}