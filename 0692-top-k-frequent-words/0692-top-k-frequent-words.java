class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair<Integer, String>> pq = new PriorityQueue<>((a, b)-> {
            if (a.getKey() == b.getKey()) {
                return b.getValue().compareTo(a.getValue());
            } else {
                return a.getKey() - b.getKey();
            }
        });
        
        List<String> answer = new ArrayList<>();
        
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> kv : map.entrySet()) {
            pq.add(new Pair<>(kv.getValue(), kv.getKey()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        while (!pq.isEmpty()) {
            answer.add(0, pq.poll().getValue());
        }
        return answer;
    }
}