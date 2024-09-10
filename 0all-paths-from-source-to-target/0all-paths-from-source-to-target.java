class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        
        traverse(graph, 0, graph.length - 1, answer, new ArrayList<>());
        
        return answer;
    }
    
    void traverse(int[][] graph, int cur, int end, List<List<Integer>> answer, List<Integer> curPath) {
        if (cur == end) {
            curPath.add(end);
            answer.add(new ArrayList<>(curPath));
            curPath.remove(curPath.size() - 1);
            return;
        }
        
        curPath.add(cur);
        for (int node : graph[cur]) {
            traverse(graph, node, end, answer, curPath);
        }
        
        curPath.remove(curPath.size() - 1);
    }
    
}