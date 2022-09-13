class Solution {
    public boolean validUtf8(int[] data) {
        String[] arr = new String[data.length];
       int p = 0;
        for(int x : data){
            String s = Integer.toString(x, 2);
            String a = "";
            for(int i = 0; i < 8- s.length(); i++){
               a+='0';
            }
            a+=s;
            arr[p++] =a ;
        }
        return isValid(arr);
    }
    boolean isValid(String[] data) {
        int i = 0;
        outer:
        while(i <  data.length){
            if(data[i].charAt(0) == '0') {
                i+=1; continue outer;
            }
            if(data.length - i == 1) return false;

            String s = data[i].substring(0,3);
            if(s.equals("110")){
                if(i+1 >= data.length || !data[i+1].substring(0,2).equals("10")) return false;
                else {i+=2; continue outer;}
            }
            s = data[i].substring(0,4);
            if(s.equals("1110")){
                if(i+2>= data.length || !data[i+1].substring(0,2).equals("10") || !data[i+2].substring(0,2).equals("10")) return false;
                else  {i+=3; continue outer;}
            }
            s = data[i].substring(0,5);
             if(s.equals("11110")) {
                 if(i+3>= data.length || !data[i+1].substring(0,2).equals("10") || !data[i+2].substring(0,2).equals("10") || !data[i+3].substring(0,2).equals("10")) return false;
                 else  {i+=4; continue outer;}
             }else return false;


        }


        return true;
    }

}

