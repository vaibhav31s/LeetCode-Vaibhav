class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder answer = new StringBuilder();
        
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        
        if (num2.length() == 1 && num2.charAt(0) == '0') return "0";
        
        int zero = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder subAns = new StringBuilder();
            
            //appending last vale zeros
            for (int x = 0; x < zero; x++) subAns.append('0');
            
            int niche = num2.charAt(i) - '0';
            int extra = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int f = num1.charAt(j) - '0';
                int mul = f * niche + extra;
                subAns.append(mul % 10);
                extra = mul / 10;
            }
            if (extra > 0) subAns.append(extra);
            subAns.reverse();
            if (answer.isEmpty()) answer = subAns;
            else answer = add(answer, subAns);
            zero++;
        }
        
        return answer.toString();
    }
    
    StringBuilder add(StringBuilder num1, StringBuilder num2) {
        StringBuilder answer = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int extra = 0;
        while (p1 >= 0 && p2 >= 0) {
            int f = num1.charAt(p1) - '0';
            int s = num2.charAt(p2) - '0';
            int sum = f + s + extra;
            answer.append((sum)% 10);
            extra  = sum / 10;
            p1--; p2--;
        }
        
        while (p1 >= 0) {
            int f = num1.charAt(p1) - '0';
            int sum = f + extra;
            answer.append((sum)% 10);
            extra  = sum / 10;
            p1--;
        }
        
        while (p2 >= 0) {
            int s = num2.charAt(p2) - '0';
            int sum = s + extra;
            answer.append((sum)% 10);
            extra  = sum / 10;
            p2--;
        }
        if (extra > 0) answer.append(extra);
        return answer.reverse();
    }
}