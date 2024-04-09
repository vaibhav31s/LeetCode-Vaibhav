class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int person = 1;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) q.add(i);
        
        int time = 0;
        while (!q.isEmpty()) {
            time++;
            Integer first = q.pollFirst();
            int val = --tickets[first];
            if (val > 0) 
                q.add(first);
            else if (first == k) return time;
        }
        
        return time;
    }
}