class TimeMap {
    HashMap<String,List<Pair>>  map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        Pair p = new Pair(value,timestamp);
        if(!map.containsKey(key)){
             map.put(key,new ArrayList<>());
            map.get(key).add(p);
        }
        else   
            map.get(key).add(p);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair>  p =  map.get(key);
        int index = -1;
        int left = 0;
        int right = p.size() - 1;
        int mid = 0;
        
       while(left < right)
        {
            mid = (left + right + 1)/2;
            
            if(p.get(mid).time == timestamp)
                return p.get(mid).value;
            else if(p.get(mid).time <= timestamp)
                left = mid;
            else
                right = mid - 1;
        }
        
        return p.get(left).time > timestamp ? "" : p.get(left).value;
    }
    class Pair {
        int time;
        String value;
        
        public Pair(String value, int time)
        {
            this.value = value;
            this.time = time;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */