class Solution {
    public int minimumPushes(String word) {
        int[] map = new int[26];
        
        for (char ch : word.toCharArray()) {
            map[ch - 'a']++;
        }
        
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int x : map) heap.add(x);
        
        int[] keyboard = new int[10];
        int curPointer = 1;
        
        while (!heap.isEmpty()) {
            int max = heap.poll();
            
            if (keyboard[curPointer] >= 8) {
                curPointer++;
            } 
            ans += curPointer * max;
            keyboard[curPointer]++;
        }
        
        return ans;
    }
}