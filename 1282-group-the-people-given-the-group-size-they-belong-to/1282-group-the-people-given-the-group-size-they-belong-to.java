class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int x = groupSizes[i];
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
        }

        map.forEach((k, v) -> {
            for (int i = 0; i < v.size(); i += k) {
                answer.add(v.subList(i, i + k));
            }
        });

        return answer;
    }
}