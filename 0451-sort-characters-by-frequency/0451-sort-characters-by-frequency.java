class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        
        
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        
        TreeMap<Integer, PriorityQueue<Character>> reverse = new TreeMap<>(Collections.reverseOrder());
        
        
        for(Character key : freq.keySet()){
            int frequency  =  freq.get(key);
            
            reverse.putIfAbsent(frequency, new PriorityQueue<>());
            reverse.get(frequency).add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int key :  reverse.keySet()){
            PriorityQueue<Character> pq = reverse.get(key)    ;
            
            while(!pq.isEmpty()){
                char ch  = pq.poll();
                for(int i = 0; i < key; i++){
                    sb.append(ch);
                }
            }
            
        }
        
        
        
        
            
            
        // System.out.println(freq);
        
        
        return  sb.toString();
        
    }
}

// tree  : e : 2 t : 1 r : 1 

//cccaaa :  