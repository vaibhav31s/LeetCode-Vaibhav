class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> alist = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) {
            alist.add(new ArrayList<>());
        }
        
        for (int[] edge : times) {
            int ui = edge[0];
            int vi = edge[1];
            int time = edge[2];
            alist.get(ui).add(new int[]{vi, time});
        }
        
        
        int[] minTime = new int[n + 1];
        
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;
        PriorityQueue<int[]> dq = new PriorityQueue<>((a, b)-> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        boolean[] vis = new boolean[n + 1];
        dq.add(new int[]{k, 0});
        
        while (!dq.isEmpty()) {
            int[] curNode = dq.poll();
            int weight = curNode[1];
            vis[curNode[0]] = true;

            if (weight > minTime[curNode[0]]) {
                continue;
            }
            for (int[] connectedNode : alist.get(curNode[0])) {
                if ((weight + connectedNode[1]) < minTime[connectedNode[0]]) {
                    minTime[connectedNode[0]] = weight + connectedNode[1];
                    dq.add(new int[]{connectedNode[0], weight + connectedNode[1]});
                }
            }
        }
        
        int min = 0;
        
        int count = -1;
        for (int x : minTime) {
            if (x != Integer.MAX_VALUE) {
                min = Math.max(min, x);
            } else {
                count++;
            }
        }
        if (count > 0) return -1;
        
        return min == 0 ? -1 : min;
    }
}