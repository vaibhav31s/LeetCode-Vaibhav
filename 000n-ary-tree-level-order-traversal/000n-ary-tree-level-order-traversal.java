/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Deque<Node> dq = new LinkedList<>();
        dq.add(root);
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> levelNodes = new ArrayList<>();
            while (size-- > 0) {
                Node curNode = dq.poll();
                levelNodes.add(curNode.val);
                for (Node child : curNode.children) {
                    dq.add(child);
                }
            }
            answer.add(levelNodes);
        }
        
        
        return answer;
    }
}