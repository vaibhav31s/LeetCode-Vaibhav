class Solution {
    public int[] countBits(int no) {
        int[] ans  = new int[no+1];
        ans[0]=0;
        for (int i = 1; i <=no ; i++) {
            String b = Integer.toString(i, 2);
            int count = 0;
            for(char ch: b.toCharArray()) if(ch == '1') count++;
            ans[i] =count;
        }
        return ans;
    }
}