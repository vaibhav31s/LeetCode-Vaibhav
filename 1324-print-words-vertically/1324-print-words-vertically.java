class Solution {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int maxlen = 0;
        for(String ss : arr){
            maxlen = Math.max(ss.length(), maxlen);
        }
        
        char[][] arrr = new char[arr.length][maxlen];
        
        for(int i = 0; i < arrr.length; i++){
            arrr[i] = new char[maxlen];
            for(int j = 0; j < arr[i].length();j++)
            arrr[i][j] = arr[i].charAt(j);
            
            for(int j =  arr[i].length(); j < maxlen;j++)
            arrr[i][j] = ' ';
            
            
            
            
//             for(int a = 0; a < arr[i].length();a++) arr[i] =  
        }
        List<String> answer =new ArrayList<>();
        
        for(int i = 0; i < arrr[0].length ; i++){
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for(int j =  arrr.length- 1; j >= 0; j--){
                if(arrr[j][i] != ' '){
                    flag = true;
                }
                
                if(flag)
                sb.append(arrr[j][i]);
            }
            
            answer.add(sb.reverse().toString());
            
            // System.out.println(Arrays.toString(arrr[i]));
        }
        
        
        
        return answer;
    }
}