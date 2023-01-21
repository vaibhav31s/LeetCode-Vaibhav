class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> answer = new ArrayList<>();
     int i = 0;
            for(int j =i +1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    for(int l = k +1; l < n; l++){
                        String first = s.substring(i, j);
                        String second = s.substring(j, k);
                        String third = s.substring(k, l);
                        String forth = s.substring(l, n);
                        if((first.length() >= 2 && first.charAt(0) == '0' ) || (second.length() >= 2 &&  second.charAt(0) == '0') || (third.length() >= 2 && third.charAt(0) == '0')  ||( forth.length() >= 2  && forth.charAt(0) == '0') ){
                            continue;
                        }
                        Long f = Long.valueOf(first);
                        Long ss = Long.valueOf(second);
                        Long t = Long.valueOf(third);
                        Long ff = Long.valueOf(forth);
                        
                        if(f <= 255 && ss <=255 && t <= 255 && ff <=255){
                            answer.add(first +"."+ second + "." + third + "." + forth);
                        }
                        
                        
                        // System.out.println(first  + " " + second + " " + third+ " " + forth);
                    }
                }
            
        }
        return answer;
    }
}