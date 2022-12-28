class Solution {
    public int minStoneSum(int[] piles, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int x : piles) pq.add(x);
        
        while(k-- >0){
            int top = pq.poll();
            top = (int)Math.ceil(top/2.0);
            pq.add(top);
            
            
        }
        int answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        
        return answer;
    }
}