class HitCounter {

    HashMap<Integer, Integer> map;
    public HitCounter() {
        map = new HashMap<>();
    }
    
    public void hit(int timestamp) {
        map.put(timestamp,map.getOrDefault(timestamp,0)+1);
     
    }
    
    public int getHits(int timestamp) {
        int start = Math.max(1, timestamp - 299);
        int count =0;
        for(int i =  start; i <= timestamp; i++){
            
            if(map.containsKey(i)){
          
                count= (count + map.get(i)) % 1000000007;
            }
        }
        
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */