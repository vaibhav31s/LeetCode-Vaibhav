class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder number = new StringBuilder();
        for(char ch  : num.toCharArray()){
            if(ch == '0'){
                number.append(ch);
            }else if(ch == '1'){
                                number.append(ch);

            }else if(ch == '6'){
                                number.append('9');

            }else if(ch == '8'){
                                number.append(ch);

            }else if(ch == '9'){
                                number.append('6');


            }else return false;
            
        }
        
        
        
        return number.reverse().toString().equals(num);
    }
}


// 0 1 6 8 9 
// 0 1 9 8 6