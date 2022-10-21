class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
     HashMap<Integer, List<Integer>> map= new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(i);
            
        }
        
        for(List<Integer> l : map.values()){
            for(int i = 0; i < l.size()-1; i++){
                if(Math.abs(l.get(i)-l.get(i+1))<= k) return true;
            }   
            
        }
    return false;
    }
    
}