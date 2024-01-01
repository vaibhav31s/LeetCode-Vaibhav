class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : s) pq.add(x);
        int count = 0;
        for(int x :  g) {
            if(pq.isEmpty()) break;
            while(!pq.isEmpty() && pq.peek() < x) {
                pq.poll();
            }
            if(pq.isEmpty()) break;
            if(pq.peek() >=  x) {
                count++;
                pq.poll();
            }
        }
            
        return  count;
    }
}   
    
    
 
// 7 9 8 10
// 5 6 7 8