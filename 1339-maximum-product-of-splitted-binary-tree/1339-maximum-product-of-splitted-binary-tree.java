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
    long answer = 0;
        long sum = 0;
        int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        sum = getSum(root);
        
        inorder(root);
        
        return (int)(answer % mod);
    }
    
    int inorder(TreeNode root){
        if(root== null) return 0;
        
        int left = inorder(root.left);
        int right= inorder(root.right);
        int summ = left + right + root.val;
        answer = Math.max(((sum - summ)* summ),answer);
        
        return left + right +root.val;
        
        
        
    }
    int getSum(TreeNode root){
        if(root== null) return 0;
        
        int left = getSum(root.left);
        int right= getSum(root.right);
        return left + right +root.val;
    }
}