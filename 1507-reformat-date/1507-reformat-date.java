class Solution {
    public String reformatDate(String date) {
        String[] arr = date.split(" ");
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String year = arr[2];
        String MM = "";
        String DD = "";
        int i = 1;
        for(String x : month){
            if(x.equals(arr[1])){
                if(i < 10){
                    MM +="0"+i;
                
                }else{
                    MM = String.valueOf(i);
                }
                break;
            }
            i++;
        }
        int a = 0;
        for(char ch : arr[0].toCharArray()){
            if(ch >='0' && ch <='9'){
                a*=10;
                a += ch -'0';
                
            }
        }
         if(a < 10){
                    DD +="0"+a;
                
                }else{
                    DD = String.valueOf(a);
                }
        return year+ "-" +MM+"-"+DD;
    }
}