class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char ch : word.toCharArray()){
            int index=  ch - 'a';
            if(temp.arr[index]==null){
                temp.arr[index] = new Node();
            }
            
            temp = temp.arr[index];
            
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
         Node temp = root;
        for(char ch : word.toCharArray()){
            int index=  ch - 'a';
            if(temp.arr[index]==null)return false;
            
            temp = temp.arr[index];
        }
        
        return temp.isEnd;
        
    }
    
    public boolean startsWith(String word) {
         Node temp = root;
        for(char ch : word.toCharArray()){
            int index=  ch - 'a';
            if(temp.arr[index]==null)return false;
            
            temp = temp.arr[index];
        }
        return true;
        
    }
}
class Node{
    Node[] arr=  new Node[26];
    boolean isEnd = false;
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */