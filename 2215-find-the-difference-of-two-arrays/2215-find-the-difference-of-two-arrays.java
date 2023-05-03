class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] map = new int[20001];
        int[] map1 = new int[20001];
        
        for(int x : nums1) map[x+1000]++;
        for(int x:  nums2) map1[x+1000]++;
        
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        
        for(int i = 0; i < 20001; i++){
            if(map[i] != 0 && map1[i] != 0){
              
            }else if(map[i]!= 0){
                ans1.add(i-1000);
            }else if(map1[i]!= 0) ans2.add(i-1000);
        }
        answer.add(ans1);
        answer.add(ans2);
        
        return answer;
    }
}