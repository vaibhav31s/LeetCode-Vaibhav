class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return go(s1.toCharArray(), s2.toCharArray(), 0, 0, new HashMap<>());
    }
    int go(char[] s1, char[] s2, int i, int j, HashMap<String, Integer>  memo){
        
        if(i >= s1.length ){
            int min = 0;
            while(j < s2.length){
                min += s2[j];
                j++;
            }
            return min;
        }
        
         if(j >= s2.length ){
            int min = 0;
            while(i < s1.length){
                min += s1[i++];
            }
            return min;
        }
        
        if(memo.containsKey(i+"-"+j))return memo.get(i+"-"+j);
        
        int ans = 0;
        
        if(s1[i] == s2[j]){
          ans = go(s1, s2, i + 1, j + 1, memo);
        }else{
            ans =  Math.min(s1[i] + go ( s1, s2, i + 1, j, memo), Math.min(s2[j] + go(s1, s2, i, j + 1, memo),s1[i] +s2[j] + go(s1, s2, i + 1, j + 1, memo)));
        }
        memo.put(i+"-"+j,ans);
        return ans;
        
    }
}

// delete
// leet

// elete   lete  lee
// leet    leet  

// delete
// eet


