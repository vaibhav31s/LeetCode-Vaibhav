class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> alist = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) alist.add(new ArrayList<>());
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            alist.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        
        int ans = 0;
        
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int last = dq.poll();
                inDegree[last]--;
                for (int x : alist.get(last)) {
                    inDegree[x]--;
                    if (inDegree[x] == 0) {
                        dq.add(x);
                    }
                }
            }
        }
        
        for (int x : inDegree) {
            if (x > 0) ans++;
        }
        return ans == 0;
    }
}