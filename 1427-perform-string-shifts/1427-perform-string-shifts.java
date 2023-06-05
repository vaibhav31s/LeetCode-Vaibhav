class Solution {
    public String stringShift(String s, int[][] shifts) {
        int total = 0;
        
        for(int[] shift : shifts)
            if(shift[0] == 0) total += shift[1]; 
            else total -= shift[1];
        
        System.out.println(total);
        if(total == 0) return s;
        
        if(total < 0){
            total %= s.length();
            return s.substring(s.length() + total, s.length())  + s.substring(0, s.length() + total);
        }
        total %= s.length();
        return s.substring(total, s.length()) + "" + s.substring(0, total);
        
        
    }
}