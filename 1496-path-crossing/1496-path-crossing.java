class Solution {
    public boolean isPathCrossing(String path) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        Pair<Integer, Integer> cur = new Pair<>(0,0);
        set.add(cur);
        for (char ch : path.toCharArray()) {
            if(ch == 'N') {
                cur = new Pair<>(cur.getKey() + 1, cur.getValue());
            } else if(ch == 'E') {
                 cur = new Pair<>(cur.getKey(), cur.getValue() + 1);
            } else if (ch == 'S') {
                 cur = new Pair<>(cur.getKey() - 1, cur.getValue());
            } else {
                 cur = new Pair<>(cur.getKey(), cur.getValue() - 1);
            }
        
            if(set.contains(cur)) return true;
                set.add(cur);
        }
        return false;
    }
}


