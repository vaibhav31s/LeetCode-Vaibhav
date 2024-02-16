class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x :  arr) 
            map.put(x, map.getOrDefault(x, 0) + 1);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int x : map.values()) {
            q.add(x);
        }
        int ans = 0;
        
        while (!q.isEmpty()) {
        
            if ((k - q.peek()) >= 0) {
                ans++;
                k -= q.poll();
            } 
            else break;
        }
        
        
        return map.size() - ans;
    }
}