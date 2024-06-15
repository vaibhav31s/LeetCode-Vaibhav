class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] pair = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            pair[i][0] = capital[i];
            pair[i][1] = profits[i];
        }
        Arrays.sort(pair, (a,b)-> a[0] - b[0]);
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int lastIndex = 0;
        
        while (k > 0) {
            for (int i = lastIndex; i < profits.length; i++) {
                if (pair[i][0] > w) break;
                pq.add(pair[i][1]);
                lastIndex = i + 1;
            }
            if (pq.isEmpty()) break;
            w += pq.poll();
            k--;
        }
        return w;
    }
}