/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> valueToIndex = new HashMap<>();
        HashMap<Integer, Node> indexAndNode = new HashMap<>();
        Node temp = head;
        int index = 0;
        while(temp != null) {
            indexAndNode.put(index, temp);
            valueToIndex.put(temp, index);
            temp = temp.next;
            index++;
        }
    
        
        HashMap<Integer, Node> answer = new HashMap<>();
        for(int i = 0; i < index; i++) {
            Node cur = indexAndNode.get(i);
            answer.put(i, new Node(cur.val));
            
        }
        for(int i = 0; i < index - 1; i++) {
            answer.get(i).next = answer.get(i + 1);
        }
        
        for(int i = 0; i < index; i++) {
            Node cur = indexAndNode.get(i);
            Node randomIndexValue =  cur.random;
            
            if (randomIndexValue == null){
            
                continue;
            
            }
            int randomIndex = valueToIndex.get(randomIndexValue);
            
            answer.get(i).random = answer.get(randomIndex);
          
            
        }
 
        // System.out.println(answer);
        
        return answer.get(0);
    }
}