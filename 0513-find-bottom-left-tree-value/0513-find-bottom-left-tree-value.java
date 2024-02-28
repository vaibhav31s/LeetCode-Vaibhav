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
    long answer  = Long.MIN_VALUE;
    int maxHeight = 0;
    public int findBottomLeftValue(TreeNode root) {
        go(root, 0);
        go1(root, 0);
        return (int) answer;
    }
    void go(TreeNode root, int height) {
        
        if(root == null)return;
        maxHeight = Math.max(height, maxHeight);
       
        go(root.left, height  + 1);
        go(root.right, height + 1);
    }
    
    void go1(TreeNode root, int height) {
        
        if(root == null)return;
        
        if(root.left == null && root.right == null) {
           
            if(answer == Long.MIN_VALUE && maxHeight == height) {
                answer = root.val;
            }    
            return;
        }
        go1(root.left, height  + 1);
        go1(root.right, height + 1);
    }
}