class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return go(nums1, nums2, 0,0, new HashMap<>());
    }
    
    int go(int[] nums1, int[] nums2, int i, int j, HashMap<String, Integer> memo){
        if(i >= nums1.length || j >= nums2.length ) return 0;
        String k = i + "-" +j;
        if(memo.containsKey(k))return memo.get(k);
        int pick = (nums1[i] == nums2[j]) ? 1 + go(nums1, nums2, i+1, j + 1, memo) : 0;
        int notPick = Math.max(go(nums1, nums2, i+1, j+1, memo),Math.max(go(nums1, nums2, i+1, j, memo), go(nums1, nums2, i, j+1, memo)));
        memo.put(k,Math.max(pick, notPick) );
        return memo.get(k);
    }
}