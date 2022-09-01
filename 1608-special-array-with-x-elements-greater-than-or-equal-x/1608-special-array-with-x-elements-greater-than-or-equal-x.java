class Solution {
    public int specialArray(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
            max = Math.max(x, max);
        }
        int[] arr = new int[10001];
        int sum = 0;
        for(int i  = max; i >= 0; i--){
            if(map.containsKey(i)){
                sum +=map.get(i);
            }
            arr[i] =  sum;
            if(arr[i] == i) return i;
        }
        return -1;
        
    }
}