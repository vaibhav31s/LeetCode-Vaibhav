class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int limit = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x :  happiness) pq.add(x);
        long answer = 0;
        while (k-- > 0) {
            int last = pq.poll();
            if (limit > last) break;
            answer += (last - limit);
            limit++;
        }
        
        
        return answer;
    }
}