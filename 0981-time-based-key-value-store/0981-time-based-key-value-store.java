class TimeMap {

    HashMap<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> map = timeMap.getOrDefault(key, new TreeMap<>());
        
        Integer eqLower = map.floorKey(timestamp);
        
        if (eqLower == null) return "";
        
        return map.get(eqLower);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */