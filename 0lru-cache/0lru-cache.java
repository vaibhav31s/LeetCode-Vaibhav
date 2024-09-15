class LRUCache {

    Node headNode = new Node(0, 0);
    Node tailNode = new Node(0, 0);
    int capacity;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        headNode.next = tailNode;
        tailNode.prev = headNode;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node k = map.get(key);
            removeNode(k);
            insertFirst(k);
            return k.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        
        
        if (map.containsKey(key)) {
            map.get(key).val = value;
            removeNode(map.get(key));
            insertFirst(map.get(key));
        } else 
        if (map.size() >= capacity) {
            
            Node last = tailNode.prev;
            map.remove(last.key);
            removeNode(last);
            map.put(key, node);
            insertFirst(node);
        } else {
             insertFirst(node);
             map.put(key, node);
        }
       
    }

    void insertLast(Node node) {
        Node last = tailNode;

        Node temp = last.prev;
        temp.next = node;
        node.next = last;
        last.prev = node;
        node.prev = temp;
    }

    void insertFirst(Node node) {
        Node temp = headNode.next;
        headNode.next = node;
        temp.prev = node;
        node.prev= headNode;
        node.next = temp;
    }

    // a < - > b < - > c
    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        next =null;
        prev= null;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */