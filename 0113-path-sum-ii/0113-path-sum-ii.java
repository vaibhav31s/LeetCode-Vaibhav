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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        backtrack(root, targetSum, path, 0, allPaths);
        return allPaths;
    }
    
    void backtrack(TreeNode root, int target, List<Integer> path, int curSum, List<List<Integer>> allPaths) {
        if (root == null){
            return;
        }
        
        if ((root.left == null && root.right == null) && curSum + root.val == target) {
            path.add(root.val);
            allPaths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }
        
        path.add(root.val);
        backtrack(root.left, target, path, curSum + root.val, allPaths);
        backtrack(root.right, target, path, curSum + root.val, allPaths);
        path.remove(path.size() - 1);
        
        
    }
    
}