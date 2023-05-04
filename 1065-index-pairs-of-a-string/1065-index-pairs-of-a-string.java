class Solution {
    public int[][] indexPairs(String text, String[] words) {
       // Arrays.sort(words);
        ArrayList<int[]> answers = new ArrayList<>();
        for(String s :  words){    
            
            ArrayList<int[]> cur = robin_karp(s,text);
            answers.addAll(cur);
            // answer
        }
//         for(int[] x: answers)
//                 System.out.println(Arrays.toString(x));
        
        int[][] answer = new int[answers.size()][2];
        Collections.sort(answers, (a,b)->{
            if(a[0] == b[0]) return a[1] -b[1];
            else return a[0]-b[0];
        });
        for(int i = 0; i < answers.size(); i++){
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
     public static ArrayList<int[]> robin_karp(String s, String t){
        //s is pattern
        //t text
        int p = 31;
        int mod = (1000000009);
        int S = s.length(), T = t.length();
        long[] p_pow = new long[Math.max(S,T)];
        p_pow[0] = 1;
        for (int i = 1; i < (int)p_pow.length; i++)
            p_pow[i] = (p_pow[i-1] * p) % mod;


        long[] h = new long[T+1];
        for (int i = 0; i < T; i++)
            h[i+1] = (h[i] + (t.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
         long h_s = 0;
        for (int i = 0; i < S; i++)
            h_s = (h_s + (s.charAt(i) - 'a' + 1) * p_pow[i]) % mod;

        ArrayList<int[]> answer = new ArrayList<>();
        int occurence = 0;
        for (int i = 0; i + S - 1 < T; i++) {
             long cur_h = (h[i+S] + mod - h[i]) % mod;
            if (cur_h == h_s * p_pow[i] % mod)
                answer.add(new int[]{i, s.length() + i-1});
        }
         
        return answer;
    }
}