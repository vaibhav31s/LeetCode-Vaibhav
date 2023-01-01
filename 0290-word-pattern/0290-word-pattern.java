class Solution {
    public boolean wordPattern(String pattern, String ss) {
        String[] s = ss.split(" ");
        HashMap<Character,Integer> first = new HashMap<>();
        HashMap<String,Integer> second = new HashMap<>();
        
        int i = 0;
        StringBuilder sb1 =  new StringBuilder();
        StringBuilder sb2 =  new StringBuilder();

        for(char ch : pattern.toCharArray()){
            
            if(!first.containsKey(ch)){
                first.put(ch, i);                
                i++;
            }
            
                 int a = first.get(ch);
                sb1.append(a+ ",");
                
        }
        
        i = 0;
        
        for(String ch : s){
            
            if(!second.containsKey(ch)){
                second.put(ch, i);                
                i++;
            }
            
                 int a = second.get(ch);
                sb2.append(a+ ",");
                
        }
        
        return sb1.toString().equals(sb2.toString());
        
    }
}