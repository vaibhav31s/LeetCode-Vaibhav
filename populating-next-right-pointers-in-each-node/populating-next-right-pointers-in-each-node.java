/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> dq = new LinkedList<>();
        if (root == null) return root;
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                Node cur = dq.poll();
                
                if (size > 0) {
                    cur.next = dq.peekFirst();
                }
                if (cur.left != null) {
                    dq.add(cur.left);
                }
                
                if (cur.right != null) {
                    dq.add(cur.right);
                }
                
                
            }
        }
        
        return root;
    }
}