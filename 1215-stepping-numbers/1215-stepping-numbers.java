class Solution {
    TreeSet<Integer> set = new TreeSet<>();
    int sw;
    int ew;
    long l;
    long h;
    public List<Integer> countSteppingNumbers(int low, int high) {          
         l = low;
         h = high;
         sw = String.valueOf(low).length();
         ew =  String.valueOf(high).length();
        
        for(int i =0; i <=9; i++){
            dfs(String.valueOf(i),i);
        }    
            sw++;
        
        return new ArrayList<>(set);
    }


    void dfs(String s, int i){
        
        if(s.length() > ew) return;
        Long a = Long.valueOf(s);
        if(a >= l && a <= h) set.add(Integer.valueOf(s)); 
        
        
        // System.out.println(s);
        if(i - 1 >= 0)
        dfs(s+(i-1),i-1);
        if(i + 1 <= 9)
        dfs(s+(i+1),i+1);

    }
}
//  while(sw <= ew){
//             for(int i = 0; i <= s.length()-sw; i++){
//                // System.out.println(s.substring(i, i+sw));
//                 String ss = s.substring(i, i+sw);
//                 StringBuilder sb = new StringBuilder(ss);
//                 String rev = sb.reverse().toString();
//                 // if(Long.valueOf(ss) > Integer.MAX_VALUE)
//                 if(Long.valueOf(ss) < Integer.MAX_VALUE && Integer.valueOf(ss) <= high && Integer.valueOf(ss) >= low)
//                 set.add(Integer.valueOf(ss));
//                 if(Long.valueOf(rev) < Integer.MAX_VALUE  && Integer.valueOf(rev) <= high  && Integer.valueOf(rev) >= low)
//                 set.add(Integer.valueOf(rev));
                
                
                
//             }
            