class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int rocki) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int answer = 0;
        
        for(int i = 0; i < rocks.length; i++){
            int dif = capacity[i] - rocks[i];
            if(dif == 0) answer++;
            else
            pq.add(dif);
            
        }
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            // System.out.println(a);
            if(rocki - a >= 0){
                rocki -= a;
                answer++;
            }else{
                break;
            }
            
        }
    
        return answer;
        
    }
    
}