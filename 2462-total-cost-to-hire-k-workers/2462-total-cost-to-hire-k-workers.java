class Solution {
    public long totalCost(int[] costs, int k, int ca) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long answer = 0;
       if(ca * 2 > costs.length){
           for(int x : costs) pq.add(x);
           while(k-- > 0){
               answer += pq.poll();
           }
       }else{
                   PriorityQueue<Integer> pq1 = new PriorityQueue<>();

           int  i = 0; 
           for(; i < ca ; i++){
               pq.add(costs[i]);
           }
           int j = costs.length -1;
           for(; j >= costs.length- ca; j--){
               pq1.add(costs[j]);
           }
           
           // System.out.println(i + " " + j);
           
           while(k-- > 0){
                          // System.out.println(i + " " + j);

                      // System.out.println(pq);
                      // System.out.println(pq1);
               if(pq.isEmpty()){
                   
                   answer += pq1.poll();
                   continue;
               }else if(pq1.isEmpty()){
                   answer += pq.poll();
                   continue;
               }

               if(pq.peek() <=  pq1.peek()){
                   answer += pq.poll();
                   
                   if(i <=  j){
                       pq.add(costs[i]);
                   i++;
                   }
               }else{
                   answer += pq1.poll();
                   if(i <= j ){
                       pq1.add(costs[j]);
                        j--;
                   }
               }
           }
       }
        
    return answer;
    }
    
}