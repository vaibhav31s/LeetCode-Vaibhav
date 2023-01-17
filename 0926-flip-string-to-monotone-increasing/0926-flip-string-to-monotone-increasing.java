class Solution {
    String s  ;
    HashMap<String, Integer> map  = new HashMap<>();
    public int minFlipsMonoIncr(String ss) {
        s= ss;
        
        
        
        return dfs( 0, '0');
    }
    
    
    int dfs(int index, char last){
       
        if(index >= s.length()){
            return 0;
        }
        String sss =  index + "," + last;
        if(map.containsKey(sss)) return map.get(sss);
         char  cur = s.charAt(index);
         int flip = Integer.MAX_VALUE;
        int noflip = Integer.MAX_VALUE;
        if(last == '0' && cur == '0'){
            flip = 1 + dfs(index+1, '1');
            noflip = dfs(index + 1, '0');
        }else if ( last == '0' && cur == '1'){
            
            flip = 1 + dfs(index+1, '0');
            noflip = dfs(index + 1, '1');
          
        }else if( last == '1' && cur == '0'){
            
            flip = 1 + dfs(index+1, '1');
        }else if(last == '1' &&  cur == '1'){
       
            noflip = dfs(index + 1, '1');
        }
        
        map.put(sss,  Math.min(flip, noflip));
        return map.get(sss);
    }
}
    