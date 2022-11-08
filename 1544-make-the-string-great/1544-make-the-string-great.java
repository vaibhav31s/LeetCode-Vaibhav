class Solution {
    public String makeGood(String s) {
       StringBuilder sb= new StringBuilder(s);
        
        while(true){
            
            boolean flag= false;
            for(int i =0;i < sb.length() - 1; i++){
                int a = Math.abs(sb.charAt(i) - sb.charAt(i+1));
                if(a == 32){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                flag=  true;
                    // i += 123123;
                    break;
                }
            }
            // System.out.println(sb);
            if(!flag) return sb.toString();
            
        }
     }
}

// l eetcode

// leEeetcode

// e

// stack : ltcode