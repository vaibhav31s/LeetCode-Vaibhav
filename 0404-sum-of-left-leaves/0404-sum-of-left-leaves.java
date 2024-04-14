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
    public int sumOfLeftLeaves(TreeNode root) {
        int answer = 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode last = q.poll();
            if (last.left != null) {
                if (last.left.left == null && last.left.right == null)
                        answer += last.left.val;
                q.add(last.left);
            }
            
            if (last.right != null) {
                q.add(last.right);
            }
            
        }
        
        return answer;
    }
}