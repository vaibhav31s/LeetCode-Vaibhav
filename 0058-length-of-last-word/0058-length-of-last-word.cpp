class Solution {
public:
    int lengthOfLastWord(string s) {
        int n=s.length()-1;
        int i=0;
        while(n >= 0 && s[n]==' '){
            
            n--;
        }
        int space = 0;
        while(n >= 0 && s[n] != ' ') space++ , n--;
        return space;
    }
};