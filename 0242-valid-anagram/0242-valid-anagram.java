class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            push(map, ch, 1);
        }
        for(char ch : t.toCharArray()) {
            if(!map.containsKey(ch)) return false;
            pull(map, ch, 1);
        }
        return map.isEmpty();
    }
     
    public static void push(HashMap<Character, Integer> map, char k, int v) {        if (!map.containsKey(k))            map.put(k, v);        else            map.put(k, map.get(k) + v);    }    public static void pull(HashMap<Character, Integer> map, char k, int v) {        int lol = map.get(k);        if (lol == v)            map.remove(k);        else            map.put(k, lol - v);    }    public static void push(HashMap<String, Integer> map, String k, int v) {        if (!map.containsKey(k))            map.put(k, v);        else            map.put(k, map.get(k) + v);    }    public static void pull(HashMap<String, Integer> map, String k, int v) {        int lol = map.get(k);        if (lol == v)            map.remove(k);        else            map.put(k, lol - v);    }    public static void push(HashMap<Long, Integer> map, Long k, int v) {        if (!map.containsKey(k))            map.put(k, v);        else            map.put(k, map.get(k) + v);    }    public static void pull(HashMap<Long, Integer> map, Long k, int v) {        int lol = map.get(k);        if (lol == v)            map.remove(k);        else            map.put(k, lol - v);    }
   
}