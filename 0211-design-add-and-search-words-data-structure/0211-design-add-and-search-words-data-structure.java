class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        for(char ch : word.toCharArray()){
            int index = ch- 'a';
            if(temp.nodes[index] ==null){
                temp.nodes[index] = new Node();
            }
            temp = temp.nodes[index];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
       
        return go(word, temp, 0);
    }
    public boolean go(String word, Node temp, int i){
        
        char ch = word.charAt(i);
        if(i == word.length()-1){
            boolean answer = false;
            
            if(ch == '.'){
                for(Node t : temp.nodes){
                    if(t== null) continue;
                    answer |= t.isEnd;
                }
                return answer;
            }
                int index = ch -'a';
                if(temp.nodes[index] == null) return false;
                return temp.nodes[index].isEnd;
        } 
        
        boolean answer =false;
        
          if(ch == '.'){
                
               for(Node t : temp.nodes){
                    if(t== null) continue;
                    answer |= go(word, t, i+1);
                }
              return answer;
          }
        
               int index = ch -'a';
                if(temp.nodes[index] == null) return false;
                return  go(word, temp.nodes[index], i+1);
              
              
          }
            
            
    
}
class Node{
    Node[] nodes = new Node[26];
    boolean isEnd = false;
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */