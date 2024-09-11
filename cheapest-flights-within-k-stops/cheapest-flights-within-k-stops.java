class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] newDistState = Arrays.copyOf(dist, n + 1);
            for (int[] flight : flights) {
                int to = flight[0];
                int from = flight[1];
                int price = flight[2];
                
                if (dist[to] != Integer.MAX_VALUE) {
                    if (dist[to] + price < newDistState[from]) {
                        newDistState[from] = dist[to] + price;
                    }
                }
            }
            dist = newDistState;
        }
        
        
        // System.out.println(Arrays.toString(dist));
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}