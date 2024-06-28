class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long answer = 0;
        List<List<Integer>> alist = new ArrayList<>();
        for (int i = 0; i < n; i++) alist.add(new ArrayList<>());
        
        //creating Adjacency List
        for (int[] road : roads) {
            int A = road[0];
            int B = road[1];
            alist.get(A).add(B);
            alist.get(B).add(A);
        }
        
        //int[] pair =0 : road , 1 : no of connections
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });
        
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i, alist.get(i).size()});
        }
        
        int value = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] last = pq.poll();
            map.put(last[0], n--);
        }
        
        
        for (int[] road : roads) {
            answer += map.get(road[0]);
            answer += map.get(road[1]);
            
        }
        
        return answer;
    }
}