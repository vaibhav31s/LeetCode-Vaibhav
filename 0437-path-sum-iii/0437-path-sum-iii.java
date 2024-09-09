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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefMap = new HashMap<>();
        go(root, targetSum, 0L, prefMap);
        return count;
    }
    void go(TreeNode root, int target, Long curSum, HashMap<Long, Integer> prefMap) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        if (curSum == target) {
            count++;
        }
        count += prefMap.getOrDefault(curSum - target, 0);
        prefMap.put(curSum, prefMap.getOrDefault(curSum, 0) + 1);
        go(root.left, target, curSum, prefMap);
        go(root.right, target, curSum, prefMap);
        prefMap.put(curSum, prefMap.getOrDefault(curSum, 0) - 1);
        
    }
}