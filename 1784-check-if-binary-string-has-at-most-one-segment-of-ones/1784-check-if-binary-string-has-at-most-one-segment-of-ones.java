class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        char last = s.charAt(0);
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
            } else {
                map.put(count, map.getOrDefault(count, 0) + 1);
                count = 0;
            }
            last = ch;
        }
        if (count > 0)map.put(count, map.getOrDefault(count, 0) + 1);
        // System.out.println(map);
        map.remove(0);
        if (map.size() == 1 ){
                for(int x : map.values()) if(x > 1) return false;
            return true;
        }
        return false;
    }
}