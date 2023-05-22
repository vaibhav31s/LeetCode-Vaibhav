class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> s = new ArrayList<>();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            
            map.put(x,map.getOrDefault(x,0)+1);
            
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> map.get(b) - map.get(a));
        for(int x : map.keySet()){
            priorityQueue.add(x);
       
        }
        
        System.out.println(map);
        
        int[] answer = new int[k];
        for (int i = 0; i <k; i++) {
            answer[i] = priorityQueue.peek();
            priorityQueue.poll();
        }
        return answer;
    
    }
}