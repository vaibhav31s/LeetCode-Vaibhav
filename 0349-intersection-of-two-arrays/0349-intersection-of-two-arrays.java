class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        HashSet<Integer> list = new HashSet<>();
        
        for (int x : nums1)  hashSet.add(x);
        
        for (int x : nums2) if(hashSet.contains(x)) if(!list.contains(x)) list.add(x);
            
        
        int[] arr = new int[list.size()];
        int i = 0;
        for (int x : list) arr[i++] = x;
        
        return arr;
    }
}