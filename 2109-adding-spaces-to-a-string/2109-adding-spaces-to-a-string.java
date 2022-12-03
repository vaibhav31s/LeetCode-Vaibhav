class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(spaces);
        int a = 0;
        for(int i =0; i < s.length(); i++){
            if(a < spaces.length){
                if(spaces[a] == i){
                    sb.append(' ');
                   a++; 
                }
                
            }
                sb.append(s.charAt(i));
            
        }
        
        
        return sb.toString();
    }
}