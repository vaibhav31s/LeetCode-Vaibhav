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
    public String smallestFromLeaf(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        go(root, list, new StringBuilder(), 0);
        Collections.sort(list);
        if (root.left == null && root.right == null) return "" +(char) (root.val + 'a');
        // System.out.println(list);x/
        return list.get(0);
    }
    
    void go(TreeNode root, ArrayList<String> ans, StringBuilder sb, int level) {
        if (root == null) return;
        char cur = (char) (root.val + 'a');
       
        if (root.left == null && root.right == null) {
            sb.append(cur);
            ans.add(sb.reverse().toString());
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(cur);
        go(root.left, ans, sb, level + 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(cur);
        go(root.right, ans, sb, level + 1);
        sb.deleteCharAt(sb.length() - 1);
    
    }
}