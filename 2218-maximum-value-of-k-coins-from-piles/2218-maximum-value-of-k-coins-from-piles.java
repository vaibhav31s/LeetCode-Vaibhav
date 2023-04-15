class Solution {
    int mod = 1000000007;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] arr = listToArray(piles);
        int answer = 0;
        int[] pointer = new int[arr.length];
        Arrays.fill(pointer, -1);
       int dp[][] = new int[1000 + 1][2000 + 1];
        
        
        return  rec(arr, 0, k, dp);
        
        
        
    }
    
    int rec(int[][] ar, int i , int k, int[][] dp){
        
        if (dp[i][k] != 0) return dp[i][k];
        
        if (i == ar.length || k == 0) return 0;
        
        int max = rec( ar,i + 1, k, dp), cur = 0;
        
        for (int j = 0; j < ar[i].length && j < k; ++j) {
            cur += ar[i][j];
            max = Math.max(max, rec(ar,i + 1, k - j - 1, dp) + cur);
        }
       
        return  dp[i][k] = max;
    }
    
    int[][] listToArray(List<List<Integer>> p){
        int[][] answer = new int[p.size()][];
        for(int i =0 ; i < p.size(); i++){
            answer[i] = new int[p.get(i).size()];
            for(int j = 0; j < p.get(i).size(); j++){
                answer[i][j] = p.get(i).get(j);
            }
        }
        
        
        return answer;
    }
}