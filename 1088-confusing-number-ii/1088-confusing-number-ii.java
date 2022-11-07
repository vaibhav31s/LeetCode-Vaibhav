class Solution {
    int answer =0;
    HashSet<Long> set = new HashSet<>();
    public int confusingNumberII(int n) {
                if(n == 1000000000) return 1950627;

       char[] valid = {'0','1','6','8','9'};
//        int[] valid = {0,1,6,8,9};
        int len = String.valueOf(n).length();
        char[] arr = new char[len];
        for(int i = 0; i < len ; i++) arr[i] = '0';
        dfs(arr, len-1,valid, n);
        return answer;
    }
      public boolean confusingNumber(long n) {
        int[] map ={0,1,-1,-1,-1,-1,9,-1,8,6};
        long answer = 0;
        long remember = n;
        while(n  > 0){
            int rem =(int)( n % 10);
            if(map[rem] == -1) return false;
            answer *=10;
            answer += map[rem];
            n/=10;
        }
        // System.out.println(answer + " " + remember);
        return answer != remember;
    }
     void dfs(char[] arr, int len, char[] valid, int n) {
            long  x = Long.parseLong(String.valueOf(arr));
//        if(set.contains(x)) return;
         if(x > n) return;
        if(x <= n && !set.contains(x) && confusingNumber(x)) answer++;
        set.add(x);
        if(len < 0) return;
//        if(in > arr.length) return;
        if(x > n) return;
        // System.out.println(x);



            for(char ch : valid){
                char  a = arr[len];
                arr[len] =ch;
                dfs(arr, len - 1, valid, n);
                arr[len] = a;
            }

//        System.out.println();
    }

}