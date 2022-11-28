class Solution {
    HashMap<Integer, Boolean > map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length) return false;
        if(set.contains(start)) return false;
        if(arr[start] == 0) return true;
        
        if(map.containsKey(start)) return map.get(start);
        
        // int max = 0;
        
        
        set.add(start);
        boolean left = canReach(arr, start - arr[start]);
        boolean right = canReach(arr, start + arr[start]);
        
         map.put(start,left ||  right);
        
        return map.get(start);
    }
}