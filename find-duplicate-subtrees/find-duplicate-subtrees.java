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
    HashMap<String, TreeNode> memo = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String , Integer> map = new HashMap<>();
        go(root, map, "-1");
        
        System.out.println(map);

        List<TreeNode> list = new ArrayList<>();
        for (Map.Entry<String, TreeNode> kv : memo.entrySet()) {
            String key = kv.getKey();
            TreeNode val = kv.getValue();
            if (map.get(key) >= 2) {
                list.add(val);
            }
        }
        return list;
    }
    
    String go(TreeNode root, HashMap<String, Integer> map, String s) {
        if (root == null) return "null";
        
        int val = root.val;
        String left = go(root.left, map, s);
        String right = go(root.right, map, s);
        String curVal = (val + "," + left + "," + right);
        map.put(curVal, map.getOrDefault(curVal, 0) + 1);
        
        memo.put(curVal, root);
        
        return curVal;
    }
}