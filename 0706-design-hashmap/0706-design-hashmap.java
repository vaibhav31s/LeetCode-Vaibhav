class MyHashMap {
    int[] mapFake;
    public MyHashMap() {
        mapFake = new int[1000001];
        Arrays.fill(mapFake, -1);
    }
    
    public void put(int key, int value) {
        mapFake[key] = value;
    }
    
    public int get(int key) {
        return mapFake[key];
        
    }
    
    public void remove(int key) {
        mapFake[key] = -1;
    }
}

//Because of hackthon easy solution sry

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */