class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String x : arr){
            char[] a = x.toCharArray();
            int start = 0;
            int end = a.length-1;
            while(start <=end){
                    char temp = a[start];
                    a[start] = a[end];
                    a[end] = temp;
                    start++;
                    end--;
            }
            if(i==0){
                sb.append(String.valueOf(a));
                i++;
            }else 
            sb.append(" "+String.valueOf(a));
            
        }
        
        return sb.toString();
        
    }
}