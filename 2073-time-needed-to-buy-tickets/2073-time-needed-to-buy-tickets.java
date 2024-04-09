class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int person = 1;
        Deque<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) q.add(new Pair(i,tickets[i]));
        
        int time = 0;
        while (!q.isEmpty()) {
            time++;
            Pair<Integer, Integer> p = q.pollFirst();
            int val = p.getValue() - 1;
            
            if (val > 0) {
                q.add(new Pair(p.getKey(), val));
            } else if (p.getKey() == k) return time;
        }
        
        return time;
    }
}