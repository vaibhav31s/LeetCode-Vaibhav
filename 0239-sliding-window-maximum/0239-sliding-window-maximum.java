class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length-k+1];
        int j = 0;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        
        for(int i = 0; i < k ; i++) { 
            
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
            
        }
        answer[0] = window.lastEntry().getKey();
        int start = 0;
        int i = 1;
        int end = k;
        while(end < nums.length){
            // System.out.println(window);
            window.put(nums[start], window.getOrDefault(nums[start], 0) - 1);          
            
            if(window.get(nums[start]) <= 0) window.remove(nums[start]);
            
            window.put(nums[end], window.getOrDefault(nums[end], 0) + 1);    
            
            start++;
            end++;
            
           
            
            answer[i++] =  window.lastEntry().getKey();
        }
        
        return answer;
    }
}