class Solution {
    
    public int[] getOrder(int[][] tasks) {
        TreeMap<Integer,ArrayList<Pair>> processes = new TreeMap<>();
        for(int i = 0; i < tasks.length; i++){
            int eT = tasks[i][0];
            int bT = tasks[i][1];
            processes.putIfAbsent(eT,new ArrayList<>());
            processes.get(eT).add(new Pair(i, eT,bT));
        }
        
        int[] answer = new int[tasks.length];
        
        int ans =0;
        Integer start = processes.firstKey();
        
        Integer end =  start ;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(b.burstTime == a.burstTime){
                return Integer.compare(a.id,b.id);
            }
            
            return Integer.compare(a.burstTime,b.burstTime);
            
        });
        // System.out.println(pq);
        while(start != null){
            if(processes.containsKey(start)){ 
               pq.addAll(processes.get(start));
            }
            
                Integer pos =processes.ceilingKey(start+1);
            while(!pq.isEmpty()){
                Pair last = pq.poll();
                int burst = last.burstTime;
                if(ans >= answer.length) return answer;
                answer[ans++] = last.id;
                // for(int i = start + 1; i <= start + burst ; i++){
                //      if(processes.containsKey(i)){ 
                //        pq.addAll(processes.get(i));
                //        pos = i;
                //     }
                // }
                
                while(pos != null && pos <= (start + burst)){
                     // pos = processes.ceilingKey(pos+1); 
                     pq.addAll(processes.get(pos));
                     pos = processes.ceilingKey(pos+1); 
                    

                }
                start = start + burst;
            }
            
            start = processes.ceilingKey(start ); 
        }
            
     
        return answer;
    }
    
}
class Pair{
    int id, enterTime, burstTime;
    Pair(int iid, int renterTime, int rburstTime){
        id = iid;
        enterTime = renterTime;
        burstTime = rburstTime;
    }
}