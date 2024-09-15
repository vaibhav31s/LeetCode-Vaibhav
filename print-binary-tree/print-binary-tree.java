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
      int h ;
    public List<List<String>> printTree(TreeNode root) {
        h = getHeight(root);
        String[][] ans = new String[h][(int) Math.pow(2, h)- 1];
        
        int n = ans[0].length;
        int mid = (n - 1)/2;
        
        go(root, 0, mid, ans);
        
        
        List<List<String>> answer = new ArrayList<>();
        for (int i = 0; i< h; i++) {
            answer.add(new ArrayList<>());
            for (String lvl : ans[i]) {
                lvl = lvl == null ? "" : lvl;
                answer.get(i).add(lvl);
            }
        }
        return answer;
    }
    
    void go(TreeNode root, int row, int col, String[][] ans) {
        if (root == null) return;
        
        ans[row][col] = String.valueOf(root.val);
        go(root.left, row + 1, col - (int) Math.pow(2, h - row - 2), ans);
        go(root.right, row + 1,col + (int) Math.pow(2, h - row - 2), ans);
        
        
    }
    
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        int left = Math.max(1 + getHeight(root.left), max);
        int right = Math.max(1 + getHeight(root.right), max);
        
        return Math.max(left, right);
        
    }
}