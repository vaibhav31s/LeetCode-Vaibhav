class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) dq.add(i);
        
        while (dq.size() > 1) {
            for (int i = 1; i < k; i++) {
                dq.add(dq.poll());
            }
            dq.poll();
        }
        return dq.poll();
    }
}