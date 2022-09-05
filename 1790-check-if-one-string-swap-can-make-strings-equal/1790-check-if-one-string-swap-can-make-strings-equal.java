class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count =0;

        char[] first = new char[2];
        char[] second = new char[2];
        
        for(int i = 0; i < s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 != ch2){
                if(count == 2) return false;
                first[count] = ch1;
                second[count] = ch2;
                count++;
            }
        }
        
        
        return first[0] == second[1] && first[1] == second[0];
    }
}