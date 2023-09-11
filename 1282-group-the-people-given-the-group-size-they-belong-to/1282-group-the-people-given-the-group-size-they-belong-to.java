class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            int x = groupSizes[i];
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(i);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        for(int x : map.keySet()) {
            List<Integer> list = map.get(x);
            for(int i = 0; i < list.size(); ) {
            List<Integer> temp = new ArrayList<>();
                for(int j = 0; j < x && i < list.size(); i++, j++) {
                    temp.add(list.get(i));
                }
            answer.add(temp);
            }
        }
        return answer;
    }
}