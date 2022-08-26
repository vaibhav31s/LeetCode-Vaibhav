class Solution {
    
    boolean ans = false;
    public boolean reorderedPowerOf2(int n) {
        StringBuilder s = new StringBuilder();
        char[] chars = String.valueOf(n).toCharArray();
        boolean[] vis = new boolean[chars.length];
        permitutation(s, chars.length, chars, vis, 0);
        
        return ans;
    }
     void permitutation(StringBuilder s, int len, char[] digits,boolean[] vis,int index){
        if(s.length() == len){
           
            int integer = Integer.parseInt(s.toString());
            if(s.charAt(0) != '0' && (Math.log10(integer) / Math.log10(2)) % 1 == 0){
                ans = true;
            }

            return;
        }
        if(ans) return;
        for(int i = 0; i < digits.length; i++){
            if(!vis[i]){
                s.append(digits[i]);
                vis[i] = true;
                permitutation(s, len, digits, vis, i);
                s.deleteCharAt(s.length()-1);
                vis[i] = false;
            }
        }
     }

}