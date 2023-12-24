class Solution {
    public int minOperations(String s) {
        boolean flag = false;
        int count1 = 0;
        for(char ch :  s.toCharArray()) { 
            if(flag && ch != '1') count1++;
            
            if(!flag && ch == '1') count1++;
            flag = !flag;
        }
        
        int count2 = 0;
        flag = false;
        for(char ch :  s.toCharArray()) { 
            if(!flag && ch != '1') count2++;
            
            if(flag && ch == '1') count2++;
            flag = !flag;
        }
        return Math.min(count1, count2);
    } 
}