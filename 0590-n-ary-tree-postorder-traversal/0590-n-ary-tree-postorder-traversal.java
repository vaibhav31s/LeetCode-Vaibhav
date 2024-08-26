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
    public List<Integer> postorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        getPostOrder(root, answer);
        answer.add(root.val);
        return answer;
    }
    
    void getPostOrder(Node root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        
    
        for (int i = 0; i < root.children.size(); i++) {
            getPostOrder(root.children.get(i), answer);
            answer.add(root.children.get(i).val);
        }
        
    }
    
}