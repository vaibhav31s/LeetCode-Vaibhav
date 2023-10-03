class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int answer = 0;
        for (int x : nums) freq[x]++;
        for(int n :  freq) answer += (n * (n-1)/2);
        return answer;
    }
}