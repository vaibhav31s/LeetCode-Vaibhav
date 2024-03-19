class Solution {
    public int leastInterval(char[] tasks, int n) {
        TreeMap<Character, int[]> map = new TreeMap<>();
        for (char ch : tasks) {
            map.putIfAbsent(ch, new int[3]);
            map.get(ch)[0]++;
            map.get(ch)[2] = (int) ch;
        }
        
        int answer = 0;
        char last = '-';
        
        out:
        while (!map.isEmpty()) {
            boolean flag = false;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
            for (char ch : map.keySet()) {
                if (map.get(ch)[1] == 0) {
                    last = ch;
                    pq.add(map.get(ch));
                }
            }
            
            if (!pq.isEmpty()) {
                    int[] p = pq.poll();
                    map.get((char) p[2])[1] = n + 1;
                    map.get((char) p[2])[0]--;
                    if (map.get((char) p[2])[0] == 0) {
                        map.remove((char) p[2]);
                    }
                    
                    last = (char) p[2];
                
            }
            
            
            
            
            //reset the timer
            for (char ch : map.keySet()) {
                map.get(ch)[1]--;
                if (map.get(ch)[1] < 0) map.get(ch)[1] = 0;
            }
            answer++;
        }
        return answer;
    }
}