class Solution {
    public int minCost(String s, int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time - b.time);
        int answer = 0;
        
        
        for(int i = 0; i < s.length();i++){
            
            char ch = s.charAt(i);
            int in = arr[i];
            
            if(pq.isEmpty()){
                pq.add(new Pair(ch,in));
            }else if(pq.peek().ch ==  ch){
                pq.add(new Pair(ch, in));
            }else{
                while(pq.size() !=1){
                    answer += pq.poll().time;
                }
                
                pq.clear();
                pq.add(new Pair(ch,in));
            }
            
            
        }
        
        while(!pq.isEmpty() && pq.size() != 1){
            answer += pq.poll().time;
        }
        
        
        
        return answer;
    }
}
class Pair{
    char ch;
    int time;
    Pair(char ch, int time){
        this.ch = ch;
        this.time = time;
    }
}