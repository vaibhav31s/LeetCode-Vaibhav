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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        HashMap<Integer, List<Integer>> levels = new LinkedHashMap<>();
        dfs(root, levels, 0);
        
        for(int key : levels.keySet()){
            List<Integer> list = levels.get(key);
            double a =  0;
            double len = list.size();
            for(int x : list){
                a +=x;
            }
            answer.add(a/len);
        }
        
        return answer;
    }
    void dfs(TreeNode root, HashMap<Integer, List<Integer>> levels, int level){
        if(root== null) return;
        levels.putIfAbsent(level, new ArrayList<>());
        levels.get(level).add(root.val);
        dfs(root.left, levels, level+1);
        dfs(root.right, levels, level+1);
    }
}