class Logger {
    HashMap<Integer, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int key = message.hashCode();
       
        if (map.containsKey(key)) {
            if(map.get(key) + 10 <= timestamp){
                map.put(key, timestamp);
                    return true;
            }
        } else {
            map.put(key, timestamp);
            return true;
        }
        
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */