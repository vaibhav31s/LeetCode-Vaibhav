class Solution {
    public int minCostToMoveChips(int[] position) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : position) map.put(x % 2, map.getOrDefault(x % 2, 0) + 1);
        if (!map.containsKey(0) || !map.containsKey(1)) return 0;
        return Math.min(map.get(0), map.get(1));
    }
}