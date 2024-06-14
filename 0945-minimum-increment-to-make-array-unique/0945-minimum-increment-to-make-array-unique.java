class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                pq.add(nums[i]);
            }
        }
        
        int answer = 0;
        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            
            while (!pq.isEmpty() && nums[i] - last  >= 2) {
                last++;
                if (last - pq.peek() <= 0) continue;
                answer += (last - pq.poll());
            }
            last = nums[i];
        }
        while (!pq.isEmpty()) {
                last++;
                int peek = pq.poll();
                answer += last - peek;
        }
        return answer;
    }
}