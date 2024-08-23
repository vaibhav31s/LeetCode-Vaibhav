class Solution {
    public String fractionAddition(String expression) {
        StringBuilder sub = new StringBuilder();
        sub.append(expression.charAt(0));
        for (int i = 1; i < expression.length() - 1; i++) {

            if ((expression.charAt(i) == '+' || expression.charAt(i)
 == '-' ) &&
              isOneToNine(expression.charAt(i - 1)) && (isOneToNine(expression.charAt(i + 1)) || expression.charAt(i + 1) == '-')) {
                sub.append("split");
                
                if (expression.charAt(i) == '-') sub.append('-');
            } else {
                sub.append(expression.charAt(i));
            }
        }
        sub.append(expression.charAt(expression.length() - 1));


        String[] subList = sub.toString().split("split");

        String ans = subList[0];
        for (int i = 1; i < subList.length; i++) {
             ans = calculate(ans, subList[i]); 
        }
        return getItSorted(ans);
    }
    
    String getItSorted(String aa) {
        int a = getValue(aa, 0);
        int b = getValue(aa, 1);
        int gcd = gcd(Math.abs(a), Math.abs(b));
        int numerator = a / gcd;
        int denominator = b / gcd;
        return numerator + "/" + denominator;
    }
    boolean isOneToNine(char ch) {
        if (ch >= '0' && ch <= '9') return true;
        
        return false;
    }
    
    String calculate(String aa, String bb) {
        
        int a = getValue(aa, 0);
        int b = getValue(aa, 1);
        int c = getValue(bb, 0);
        int d = getValue(bb, 1);
        
        
        int numerator = (a * d) + (c * b);
        int denominator = b * d;
        return numerator + "/" + denominator;
    }
    
    int getValue(String a, int ind) {
        String[] split = a.split("/");
        return Integer.parseInt(split[ind]);
    }
    
     int gcd(int a, int b){
      if (b == 0)
        return a;
      return gcd(b, a % b); 
    }
    
}