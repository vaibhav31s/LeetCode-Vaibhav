class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = 0;
        for(int x :  g) {
            while(j < s.length && s[j] < x) {
                j++;
            }
            
            if(j < s.length && s[j] >=  x) {
                count++;
                j++;
            }
        }
            
        return  count;
    }
}   
    
    
 
// 7 9 8 10
// 5 6 7 8