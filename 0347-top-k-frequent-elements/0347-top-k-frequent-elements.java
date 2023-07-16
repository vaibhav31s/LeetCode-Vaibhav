class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int x :  nums) frequencyMap.put(x, frequencyMap.getOrDefault(x, 0)+1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
        
        for(int freq : frequencyMap.keySet()){
            pq.add(new Pair(frequencyMap.get(freq),freq));
        }
        
        int[] answer = new int[k];
        
        for(int i = 0; i < k ; i++){
            answer[i] = pq.poll().number;
        }
        
        return answer;
    }
    private class Pair{
        int frequency;
        int number;
        Pair(int fr, int no){
            frequency = fr;
            number = no;
        }
    }
}