/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        HashMap<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        dfs(root, 0, 0, map);
        
        List<Integer> keyset = new ArrayList<>(map.keySet());
        Collections.sort(keyset);
        int i = 0;
        for(int key : keyset){
            answer.add(new ArrayList<>());
            while(!map.get(key).isEmpty()){
                Pair p= map.get(key).poll();
                answer.get(i).add(p.val);
            }
            i++;
        }
        
        return answer;
    }
    
    void dfs(TreeNode root, int height, int graph,  HashMap<Integer, PriorityQueue<Pair>> map){
        if(root == null) return;
        map.putIfAbsent(graph, new PriorityQueue<>((a,b)->(a.pos == b.pos) ? a.val - b.val : a.pos - b.pos));
        map.get(graph).add(new Pair(root.val,height));
        dfs(root.left, height+1, graph-1, map);
        dfs(root.right, height+1, graph+1, map);
        
    }
}
class Pair{
    int val;
    int pos;
    Pair(int val, int pos){
        this.val = val;
        this.pos = pos;
    }
}