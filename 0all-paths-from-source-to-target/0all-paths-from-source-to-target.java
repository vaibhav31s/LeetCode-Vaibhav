class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Deque<Pair<Integer, List<Integer>>> dq = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        dq.add(new Pair<>(0, new ArrayList<>()));
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                Pair<Integer, List<Integer>> curPair = dq.poll();
                int curNode = curPair.getKey();
                List<Integer> curList = curPair.getValue();
                
                if (curNode == graph.length - 1) {
                    curList.add(graph.length - 1);
                    answer.add(curList);
                    continue;
                }
                
                
                
                for (int node : graph[curNode]) {
                    List<Integer> deepCopy = new ArrayList<>(curList);
                    deepCopy.add(curNode);
                    dq.add(new Pair<>(node, deepCopy));
                }
            }
        }
        
        return answer;
    }
}