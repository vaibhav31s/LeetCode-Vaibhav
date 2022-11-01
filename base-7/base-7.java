class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNeg = num >=0;
        num = Math.abs(num);
        while(num >= 7){
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(num % 7);
        if(isNeg) return sb.reverse().toString();
        
        sb.append("-") ;
        return sb.reverse().toString();
    
}
}

// 1010
//     8+0+2+0
// 10
// 0
// 8 % 7 = 1
// 1 % 7 = 1