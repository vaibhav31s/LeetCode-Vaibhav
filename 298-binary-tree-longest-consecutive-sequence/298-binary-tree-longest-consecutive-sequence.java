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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        
        
        dfs(root,0,root.val);
        return max;
        
    }
    void dfs(TreeNode root, int count, int prev){
        if(root == null) return;
        if(root.val - prev == 1){
            count++;
            max = Math.max(count, max);
        }else{
            count = 1;
        }
        dfs(root.left, count, root.val);
        dfs(root.right, count, root.val);
        
        
    }
}