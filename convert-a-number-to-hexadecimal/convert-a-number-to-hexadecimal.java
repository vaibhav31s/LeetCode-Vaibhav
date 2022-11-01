class Solution {
    static   HashMap<String,Character> hex = new HashMap<>();
    static boolean flag = false;
    public String toHex(int num) {
        StringBuilder sb  = new StringBuilder();
      if(!flag){
        hex.put("0000",'0');
        hex.put("0001",'1');
        hex.put("0010",'2');
        hex.put("0011",'3');
        hex.put("0100",'4');
        hex.put("0101",'5');
        hex.put("0110",'6');
        hex.put("0111",'7');
        hex.put("1000",'8');
        hex.put("1001",'9');
        hex.put("1010",'a');
        hex.put("1011",'b');
        hex.put("1100",'c');
        hex.put("1101",'d');
        hex.put("1110",'e');
        hex.put("1111",'f');
      flag = true;
      }
      
        if(num == 0) return "0";
        
        for(int i = 0; i < 32; i++){
            int mask = 1 << i;
            if((num & mask) != 0 )
            sb.append(1);
            else sb.append(0);
        }
        char last  = '0';
        // System.out.println();
        sb.reverse();
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i <= 32 - 4; i +=4){
            if(last == '0' && hex.get(sb.substring(i,i+4)) == '0'){
                continue;
            }else{
                last = '1';
                
            }
            answer.append(hex.get(sb.substring(i, i+4)));
        }
        return answer.toString();
    }
}