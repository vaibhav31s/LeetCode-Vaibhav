class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int x : nums) set.add(x);
        int answer = 0;
        int last =Integer.MIN_VALUE;
        int continuous = 0;
        for(int x : set){
            if(Math.abs(last - x) == 1){
                continuous++;
            }else{
                continuous = 1;
            }
            answer = Math.max(continuous, answer);
            last = x;
        }
        
        
        return answer;
    }
}