class Solution {
    HashSet<String> result;
    int  m;
    int nn ;
    public List<String> findWords(char[][] board, String[] words) {
        
        result = new HashSet<>();
         m = board.length;
         nn = board[0].length;
         Node n = new Node();
        for(String s : words){
            insert(n,s);
        }
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < nn; j++){
                if(n.nodes[board[i][j] - 'a'] != null)
                findTrieWord(board, i, j, m,nn,n);
            }
        }
        List<String> answer = new ArrayList<>();
        
        for(String s : result) answer.add(s);
        return answer;
    }
void findTrieWord(char[][] b, int i , int j, int m , int n, Node root){
    if(i < 0 || j < 0 || i >= m || j >= n || b[i][j] == '$' || root.nodes[b[i][j] - 'a'] == null) return;  
    
    char V = b[i][j];

    // System.out.println(V);
   if(root.nodes[b[i][j] - 'a'].flag){
        result.add(root.nodes[V - 'a'].word);
       
   }
    
    root = root.nodes[V - 'a'];
    b[i][j] = '$';
    findTrieWord(b, i +1 , j, m, n, root);
    findTrieWord(b, i , j + 1, m, n,root);
    findTrieWord(b, i - 1, j, m, n, root);
    findTrieWord(b, i, j - 1, m, n, root);
   
    
    b[i][j] = V;
    
    
    
    
}    
// node find(node n , String s){
//     node p = n;
//     for(char ch : s.toCharArray()){
//         if(n.child[ch - 'a'] ==  null) return p;
//         p = n.child[ch- 'a'];
//     }
//     return p;
// }
 public void insert(Node root,String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            if(temp.nodes[c - 'a'] == null){
                temp.nodes[c - 'a'] = new Node();
            }
            temp = temp.nodes[c - 'a'];
        }
        temp.flag = true;
     temp.word = word;
    }
}
class Node{
    Node[] nodes = new Node[26];
    boolean flag = false;
    String word ="";
}